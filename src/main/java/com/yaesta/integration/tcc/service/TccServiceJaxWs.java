package com.yaesta.integration.tcc.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;

import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.GuideRepository;
import com.yaesta.app.persistence.repository.OrderRepository;
import com.google.gson.Gson;
import com.yaesta.app.persistence.entity.CoberturaTCC;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.service.CoberturaTCCService;
import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.app.persistence.service.YaEstaLogService;
import com.yaesta.app.service.SystemOutService;
import com.yaesta.app.util.ObjectUtil;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;
import com.yaesta.integration.vitex.json.bean.Dimension;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;
import com.yaesta.integration.base.enums.DeliveryEnum;
import com.yaesta.integration.base.util.BaseUtil;
import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.tcc.vo.TCCTraceVO;

import co.com.tcc.clientes.ArrayOfRemesa;
import co.com.tcc.clientes.ArrayOfRemesaEstados;
import co.com.tcc.clientes.ConsultarInformacionRemesasEstados;
import co.com.tcc.clientes.ConsultarInformacionRemesasEstadosResponse;
import co.com.tcc.clientes.GrabarDespacho4;
import co.com.tcc.clientes.GrabarDespacho4Response;
import co.com.tcc.clientes.ObjectFactory;
import co.com.tcc.clientes.Remesa;
import co.com.tcc.clientes.RemesaEstados;
import co.com.tcc.xsd.ObjectFactoryXSD;
import co.com.tcc.xsd.TpDocumentoReferencia;
import co.com.tcc.xsd.TpGrabarRemesaCompleta;
import co.com.tcc.xsd.TpUnidad;

@Service
public class TccServiceJaxWs implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4087082377213009849L;

	@Autowired
	WebServiceTemplate webServiceTemplateTCC;

	@Autowired
	YaEstaLogService logService;

	@Autowired
	CoberturaTCCService coberturaTccService;

	@Autowired
	TableSequenceService tableSequenceService;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	@Autowired
	SystemOutService systemOut;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	GuideRepository guideRepository;

	public JAXBContext context = JAXBContext.newInstance();

	public ObjectFactory objectFactory = new ObjectFactory();
	public ObjectFactoryXSD objectFactoryXSD = new ObjectFactoryXSD();

	protected @Value("${tcc.service.user}") String tccServiceUser;
	protected @Value("${tcc.service.password}") String tccServicePassword;
	protected @Value("${tcc.service.pdf.path}") String tccServicePdfPath;
	protected @Value("${tcc.service.pdf.guide.prefix}") String tccServicePdfGuidePrefix;
	protected @Value("${tcc.service.pdf.rotule.prefix}") String tccServicePdfRotulePrefix;
	protected @Value("${tcc.service.business.unit}") String tccBusinessUnit;
	protected @Value("${tcc.service.business.account}") String tccBusinessAccount;
	protected @Value("${tcc.service.clase.empaque}") String tccServiceClaseEmpaque;
	protected @Value("${tcc.service.tipo.unidad}") String tccServiceTipoUnidad;
	protected @Value("${yaesta.ruc}") String yaestaRuc;
	protected @Value("${yaesta.razon.social}") String yaestaRazonSocial;
	protected @Value("${datil.iva.value}") String datilIvaValue;
	protected @Value("${datil.iva.percent.value}") String datilIvaPercentValue;
	private @Value("${yaesta.log.path}") String yaestaLogPath;
	private @Value("${yaesta.log.prefix.tcc}") String yaestaPrefixTcc;

	public TccServiceJaxWs() throws Exception {
	}

	public GuideDTO generateGuides(GuideDTO guideInfo) {

		GuideDTO result = new GuideDTO();
		result.setResponse("OK");

		try {

			

			// String response = "OK";

			systemOut.println("# proveedores " + guideInfo.getOrderComplete().getSupplierDeliveryInfoList().size());
			List<GuideBeanDTO> resultGuideBeanList = new ArrayList<GuideBeanDTO>();
			for (SupplierDeliveryInfo sdi : guideInfo.getOrderComplete().getSupplierDeliveryInfoList()) {
				GuideBeanDTO gbd = new GuideBeanDTO();
				List<String> errorInfo = SupplierUtil.validateSupplierInfo(sdi.getSupplier());
				gbd.setSupplier(sdi.getSupplier());
				boolean addGdb = true;

				if (errorInfo.isEmpty() && sdi.getSelected() && guideInfo.getDeliverySelected() != null
						&& guideInfo.getDeliverySelected().getNemonic().equals(DeliveryEnum.TCC.getNemonic())) {
					TpGrabarRemesaCompleta objDespacho = objectFactoryXSD.createTpGrabarRemesaCompleta();

					objDespacho.setClave(tccServicePassword);
					// documentacion dice enviar vacio
					objDespacho.setFechahoralote(UtilDate.fromDateToString(new Date()));
					objDespacho.setUnidadnegocio(tccBusinessUnit);
					objDespacho.setFechadespacho(UtilDate.fromDateToString(new Date()));
					objDespacho.setCuentaremitente(tccBusinessAccount);
					objDespacho.setIdentificacionremitente(yaestaRuc);
					objDespacho.setTipoidentificacionremitente("NIT");
					

					String localeSource = sdi.getSupplier().getTccCode();
					if (localeSource != null) {
						objDespacho.setCiudadorigen(localeSource);
					}
					
					objDespacho.setDireccionremitente(sdi.getSupplier().getAddress());
					objDespacho.setTelefonoremitente(sdi.getSupplier().getPhone());
					
					String province = guideInfo.getOrderComplete().getShippingData().getAddress().getState()
							.toUpperCase();
					String canton = guideInfo.getOrderComplete().getShippingData().getAddress().getCity().toUpperCase();
					String parroquia = canton;
					List<CoberturaTCC> coberturaTccList = coberturaTccService.findByProvinciaCantonParroquia(province,
							canton, parroquia);

					if (coberturaTccList != null && !coberturaTccList.isEmpty()) {
						objDespacho.setCiudaddestinatario(coberturaTccList.get(0).getCodigo());
					}

					objDespacho.setPrimernombredestinatario(
							guideInfo.getOrderComplete().getClientProfileData().getFirstName());
					objDespacho.setPrimerapellidodestinatario(
							guideInfo.getOrderComplete().getClientProfileData().getLastName());
					objDespacho.setIdentificaciondestinatario(
							guideInfo.getOrderComplete().getClientProfileData().getDocument());
					objDespacho.setTelefonodestinatario(guideInfo.getOrderComplete().getClientProfileData().getPhone());

					String direccionDestinatario = guideInfo.getOrderComplete().getShippingData().getAddress()
							.getStreet();
					String complemento = guideInfo.getOrderComplete().getShippingData().getAddress().getComplement();
					if (complemento != null) {
						direccionDestinatario = direccionDestinatario + " " + complemento;
					}
					objDespacho.setDirecciondestinatario(direccionDestinatario);
					String docType[] = determineDocumentType(
							guideInfo.getOrderComplete().getClientProfileData().getDocument());

					objDespacho.setNaturalezadestinatario(docType[1]); // confirmar
					objDespacho.setTipoidentificaciondestinatario(docType[0]); // confirmar

					objDespacho.setGenerarDocumentos(true);

					String formaPago = "N/A";
					if (guideInfo.getOrderComplete().getPaymentData().getTransactions() != null
							&& !guideInfo.getOrderComplete().getPaymentData().getTransactions().isEmpty()) {
						for (Transaction tr : guideInfo.getOrderComplete().getPaymentData().getTransactions()) {
							if (tr.getPayments() != null && !tr.getPayments().isEmpty()) {
								for (Payment py : tr.getPayments()) {
									formaPago = py.getPaymentSystemName();
									if (py.getPaymentSystemName()
											.equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())) {
										formaPago = formaPago + ": " + PagoEnum.EFECTIVO.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())) {
										formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES
													.getPaymentSystemName())) {
										formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.PAYCLUB.getPaymentSystemName())) {
										formaPago = formaPago + ": "
												+ PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())) {
										formaPago = formaPago + ": "
												+ PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())) {
										formaPago = formaPago + ": "
												+ PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									} else if (py.getPaymentSystemName()
											.equals(PaymentEnum.PAYPAL.getPaymentSystemName())) {
										formaPago = formaPago + ": "
												+ PagoEnum.TARJETA_CREDITO_INTERNACIONAL.getDescripcionSRI();
									}

								} // fin for

							} //
						}
					}

					Double shippingValue = 0D;
					Double partialShipping = 0D;
					Double ivaPartial = 0D;

					for (Total vtot : guideInfo.getOrderComplete().getTotals()) {

						if (vtot.getId().equals("Shipping")) {
							shippingValue = shippingValue + vtot.getValue();
						}
					}

					if (shippingValue > 0) {

						if (guideInfo.getOrderComplete().getSupplierDeliveryInfoList() != null
								&& !guideInfo.getOrderComplete().getSupplierDeliveryInfoList().isEmpty()) {

							partialShipping = shippingValue
									/ guideInfo.getOrderComplete().getSupplierDeliveryInfoList().size();
							partialShipping = BaseUtil.roundValue(partialShipping);
							ivaPartial = BaseUtil.calculateIVA(partialShipping, new Integer(datilIvaValue),
									datilIvaPercentValue);
							partialShipping = partialShipping + ivaPartial;
							partialShipping = BaseUtil.roundValue(partialShipping);
						}
					}

					systemOut.println("PartialShipping " + partialShipping);

					Double deliveryPayment = 0D;
					Boolean hasAdjunto = false;
					if (guideInfo.getOrderComplete().getPaymentData().getTransactions() != null
							&& !guideInfo.getOrderComplete().getPaymentData().getTransactions().isEmpty()) {
						for (Transaction tr : guideInfo.getOrderComplete().getPaymentData().getTransactions()) {
							if (tr.getPayments() != null && !tr.getPayments().isEmpty()) {
								for (Payment py : tr.getPayments()) {
									if (py.getPaymentSystemName().trim().toLowerCase().equals(
											PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName().toLowerCase())) {
										hasAdjunto = true;
										deliveryPayment = deliveryPayment + py.getValue();
									}
								} // fin for

							} //
						}
					} // fin payment data
					/*
					String observacionText = "Orden: " + guideInfo.getOrderComplete().getOrderId() + " de "
							+ guideInfo.getOrderComplete().getCustomerName() + " "
							+ guideInfo.getOrderComplete().getClientProfileData().getDocument() + " \n ";
					observacionText = observacionText + "Forma de Pago: " + formaPago;
					*/
					String observacionText = "Orden: " + guideInfo.getOrderComplete().getOrderId()+ " ";
						   observacionText = observacionText + " Forma de Pago: " + formaPago+ " \n ";

					if (guideInfo.getCustomerAdditionalInfo() != null
							&& !guideInfo.getCustomerAdditionalInfo().equals("")) {
						observacionText = observacionText + "Referencia" + guideInfo.getCustomerAdditionalInfo();
					}

					objDespacho.setObservaciones(observacionText);
					objDespacho.setFormapago(""); // Validar TCC en pruebas
													// indican que se envie
													// vacio

					// remitente
					//objDespacho.setPrimernombreremitente("YAESTA: " +sdi.getSupplier().getName()); //En atencion a solicitud del 21-04-2017
					objDespacho.setPrimernombreremitente(sdi.getSupplier().getName());
					objDespacho.setPrimerapellidoremitente(
							sdi.getSupplier().getContactName() + " " + sdi.getSupplier().getContactLastName());
					objDespacho.setDireccionremitente(sdi.getSupplier().getAddress());
					objDespacho.setTelefonoremitente(sdi.getSupplier().getPhone());
				

					String docTypeSup[] = determineDocumentType(yaestaRuc);

					objDespacho.setNaturalezaremitente(docTypeSup[1]); // confirmar
					objDespacho.setTipoidentificacionremitente(docTypeSup[0]); // confirmar

					objDespacho.setRazonsocialremitente(yaestaRazonSocial);

					// Items
                    String desc = "";
					Long ite = new Long(1);
					Double itemValue = 0D;
					Double deliveryCost = 0D;
					Double totalValue = 0D;
					Double totalAsegurado = 0D;
					
					
					if (hasAdjunto && partialShipping > 0) {
								totalValue = partialShipping;
					}
					
					TpUnidad unidad = new TpUnidad();
					systemOut.println("# items " + sdi.getItems().size());
					List<GuideDetail> detailList = new ArrayList<GuideDetail>();
					for (ItemComplete ic : sdi.getItems()) {
						itemValue = 0D;
						systemOut.println("Ite==>> " + ite);
						ite++;
						Dimension dim = (Dimension) ic.getAdditionalProperties().get("dimension");

						if (dim != null) {
							unidad.setAlto(dim.getHeight() + "");
							unidad.setAncho(dim.getWidth() + "");
							unidad.setLargo(dim.getLength() + "");
							unidad.setPesovolumen(dim.getWeight() + "");
						} else {
							unidad.setAlto("0");
							unidad.setAncho("0");
							unidad.setLargo("0");
							unidad.setPesovolumen("0");
						}

						if (sdi.getItemIdentityType() != null
								&& sdi.getItemIdentityType().getNemonic().equals("NOMBREPRODUCTO")) {
							desc = desc + "#Can. " + ic.getQuantity() + " PRO:" + ic.getName() + " _ ";
						} else {
							String[] supplierCodes = SupplierUtil.returnSupplierCode((String) ic.getRefId());
							desc = desc + "#Can. " + ic.getQuantity() + " COD:" + supplierCodes[2] + " _ ";
						}

						if (desc.length() > 250) {
							desc = desc.substring(0, 250);
						}

						unidad.setDicecontener(desc);
						unidad.setTipounidad(tccServiceTipoUnidad);
						unidad.setClaseempaque(tccServiceClaseEmpaque);
						unidad.setKilosreales("1");

						itemValue = itemValue + ic.getPrice() * ic.getQuantity();
						itemValue = (double) Math.round(itemValue * 100) / 100;
						// systemOut.println("1> "+itemValue+ " "+totalValue);
						Double discount = 0D;
						Boolean hasTax = Boolean.FALSE;
						if (ic.getPriceTags() != null && !ic.getPriceTags().isEmpty()) {
							for (PriceTag pt : ic.getPriceTags()) {
								if (pt.getName().contains("discount@price")) {
									Double val = pt.getValue();
									if (val < 0) {
										val = val * (-1);
									}
									val = (double) Math.round(val * 100) / 100;
									discount = discount + Math.abs(val);
									// break;
								}
								if (pt.getName().contains("DISCOUNT@MARKETPLACE")) {
									Double val = pt.getValue();
									if (val < 0) {
										val = val * (-1);
									}
									val = (double) Math.round(val * 100) / 100;
									discount = discount + Math.abs(val);
								}
								if (pt.getName().contains("tax@price")) {
									hasTax = Boolean.TRUE;
								}
							}
						} else {
							discount = 0D;
						}

						if (ic.getShippingPrice() != null) {
							systemOut.println("shippingPrice " + ic.getShippingPrice());
							unidad.setValormercancia(ic.getShippingPrice() + "");
							deliveryCost = deliveryCost + ic.getShippingPrice();
						} else {
							systemOut.println("Sin costo de cobro de envio");
							// carga.setValorCobro(0D);
						}
						Double iva = 0D;
						totalAsegurado = totalAsegurado + itemValue;
						totalAsegurado = (double) Math.round(totalAsegurado * 100) / 100;
						itemValue = itemValue - discount;
						itemValue = (double) Math.round(itemValue * 100) / 100;

						// systemOut.println("2> "+itemValue+ " "+totalValue);

						if (ic.getTax() > 0) {
							iva = ic.getTax();
						} else {
							if (hasTax) {
								iva = BaseUtil.calculateIVA(itemValue, new Integer(datilIvaValue),
										datilIvaPercentValue);
							}
						}
						if (itemValue.intValue() > 0) {
							itemValue = itemValue + iva;
						}
						itemValue = (double) Math.round(itemValue * 100) / 100;

						// systemOut.println("3> "+itemValue+ " "+totalValue);
						totalValue = totalValue + itemValue;
						totalValue = (double) Math.round(totalValue * 100) / 100;
						if (hasAdjunto && itemValue.intValue() > 0) {

							TpDocumentoReferencia docReferencia = new TpDocumentoReferencia();

							String codigoAdjunto = getAdjCode();
							systemOut.println("Codigo Adjunto " + codigoAdjunto);
							docReferencia.setNumerodocumento(codigoAdjunto);
							// docReferencia.setNumerodocumento(guideInfo.getOrderComplete().getOrderId());
							docReferencia.setTipodocumento("FA"); // confirmar
							docReferencia.setFechadocumento(UtilDate.fromDateToString(new Date()));

							objDespacho.getDocumentoreferencia().add(docReferencia);
						} else {

							systemOut.println("No hay adjunto");
							objDespacho.setTotalvalorproducto("");
							
							
						}
						
						objDespacho.setTotalvalorproducto("");

						systemOut.println("Total Valor producto " + totalValue);
						objDespacho.setTotalvalormercancia(totalAsegurado.toString());
						
						if(hasAdjunto){
							objDespacho.setTotalvalorproducto(totalValue.toString());
				//			objDespacho.setTotalvalorproducto("");
						}else
						{
							TpDocumentoReferencia docReferencia = new TpDocumentoReferencia();

							docReferencia.setNumerodocumento("0");
							docReferencia.setTipodocumento("FA"); // confirmar
							docReferencia.setFechadocumento(UtilDate.fromDateToString(new Date()));

							objDespacho.getDocumentoreferencia().add(docReferencia);
						}
						

						// documentacion dice enviar vacio
						// objDespacho.setCodigolote(guideInfo.getOrderComplete().getOrderId());
						objDespacho.setCodigolote(getLoteCode());
						// objDespacho.setNumeroDepacho(guideInfo.getOrderComplete().getOrderId());
						objDespacho.setNumeroReferenciaCliente(guideInfo.getOrderComplete().getOrderId());

						GuideDetail guiD = new GuideDetail();
						guiD.setItemName(ic.getName());
						guiD.setOrderVitexId(guideInfo.getOrderComplete().getOrderId());
						guiD.setVitexId(ic.getId());
						guiD.setQuantity(new Long(ic.getQuantity()));
						guiD.setItemValue(itemValue);
						guideInfo.getDetails().add(guiD);
						detailList.add(guiD);

					} // for de items
					StringBuilder temp = new StringBuilder(objDespacho.getObservaciones()+" "+desc);
					if(hasAdjunto){
						
						temp.append("\n VALOR A RECAUDAR: " + totalValue);
						
					}
					objDespacho.setObservaciones(temp.toString());
					
					
					systemOut.println("Total Asegurado " + totalAsegurado);
					// unidad.setValormercancia(formatProductValue(totalAsegurado));
					unidad.setValormercancia("00");
					unidad.setNumerobolsa("1");
					unidad.setReferencias("");
					unidad.setCodigobarras("");
					unidad.setTipoempaque("");
					unidad.setCantidadunidades("1");

					unidad = (TpUnidad) ObjectUtil.replaceNullString(unidad);
					objDespacho.getUnidad().add(unidad);
					objDespacho.setFuente("WSTCC");
					objDespacho = (TpGrabarRemesaCompleta) ObjectUtil.replaceNullString(objDespacho);

					GrabarDespacho4 gdes = objectFactory.createGrabarDespacho4();
					gdes.setObjDespacho(objDespacho);
					gdes = (GrabarDespacho4) ObjectUtil.replaceNullString(gdes);
					String json = new Gson().toJson(gdes);

					systemOut.println("Objeto " + json);
					// Intentar mandar a grabar el objeto antes de generar la
					// llamada a servicio de TCC
					// buildLog(json,guideInfo.getOrderComplete().getOrderId(),null);
					buildLog(gdes, guideInfo.getOrderComplete().getOrderId(), null);
					GrabarDespacho4Response gdesResponse = (GrabarDespacho4Response) webServiceTemplateTCC
							.marshalSendAndReceive("http://clientes.tcc.com.co/servicios/wsdespachos.asmx", gdes,
									new SoapActionCallback("http://clientes.tcc.com.co/GrabarDespacho4"));

					// "http://clientes.tcc.com.co/"

					systemOut.println("TCC Remesa: " + gdesResponse.getMensaje());

					System.out.println("TCC Remesa: " + gdesResponse.getMensaje());

					String json2 = new Gson().toJson(gdesResponse);

					systemOut.println("Objeto2 " + json2);
					// Intentar mandar a grabar el objeto antes de generar la
					// llamada a servicio de TCC
					buildLog(gdesResponse, guideInfo.getOrderComplete().getOrderId(), "RESPONSE");

					String message = gdesResponse.getMensaje();

					if (message.contains("ORA-") || message.contains("ERROR") || message.contains("Exception")) {
						YaEstaLog yaestalog = new YaEstaLog();
						yaestalog.setLogDate(new Date());
						yaestalog.setProcessName("WAYBILL-TCC");
						yaestalog.setTextinfo("TCC Remesa : Error: " + message);
						yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
						logService.save(yaestalog);
						result.setResponse("ERROR");
						addGdb = false;
					} else if (   gdesResponse != null 
							   && gdesResponse.getRemesa() != null 
							   && !gdesResponse.getRemesa().equals("-1")) { 	// escribir
																				// los
																				// archivos
						gbd.setItemValue(itemValue);
						gbd.setDeliveryCost(deliveryCost);
						gbd.setDeliveryPayment(deliveryPayment);
						gbd.setItemList(sdi.getItems());
						gbd.setHasPayment(hasAdjunto);
						gbd.setTotalValue(totalValue);
						gbd.setResponse("OK");
						gbd.setDeliveryName("TCC");
						gbd.setGuideNumber(gdesResponse.getRemesa());
						gbd.setDetails(detailList);

						if (gdesResponse.getIMGRelacionEnvio() != null && gdesResponse.getIMGRotulos() != null) {
							String guideName = tccServicePdfPath + tccServicePdfGuidePrefix
									+ guideInfo.getOrderComplete().getOrderId() + "_" + gdesResponse.getRemesa() + "_"
									+ (new Date()).getTime() + ".pdf";
							String rotuleName = tccServicePdfPath + tccServicePdfRotulePrefix
									+ guideInfo.getOrderComplete().getOrderId() + "_" + gdesResponse.getRemesa() + "_"
									+ (new Date()).getTime() + ".pdf";

							System.out.println("GuideName " + guideName);
							System.out.println("RotuleName " + rotuleName);
							// FileUtils.writeByteArrayToFile(new
							// File(guideName),gdesResponse.getIMGRemesa());
							FileUtils.writeByteArrayToFile(new File(guideName), gdesResponse.getIMGRelacionEnvio());
							FileUtils.writeByteArrayToFile(new File(rotuleName), gdesResponse.getIMGRotulos());
							gbd.setPdfUrl(guideName);
							gbd.setPdfRotuleUrl(rotuleName);
							result.setResponse("OK");
						} else {
							System.out.println("No contiene salida PDF");
							YaEstaLog yaestalog = new YaEstaLog();
							yaestalog.setLogDate(new Date());
							yaestalog.setProcessName("WAYBILL-TCC");
							yaestalog.setTextinfo("TCC Remesa : Error: " + "No contiene salida PDF");
							yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
							logService.save(yaestalog);
							addGdb = false;
							result.setResponse("ERROR");
						}

						// Grabar log en caso de exito
						YaEstaLog yaestalog = new YaEstaLog();
						yaestalog.setLogDate(new Date());
						yaestalog.setProcessName("WAYBILL-TCC");
						yaestalog.setTextinfo("TCC Remesa :" + gdesResponse.getMensaje());
						yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
						logService.save(yaestalog);
						//
					} else {
						result.setResponse("ERROR");
						System.out.println("No hay response en objeto");
						YaEstaLog yaestalog = new YaEstaLog();
						yaestalog.setLogDate(new Date());
						yaestalog.setProcessName("WAYBILL-TCC");
						yaestalog.setTextinfo("TCC Remesa : Error Response: " + message);
						yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
						logService.save(yaestalog);
						
						addGdb = false;
					}
					if (addGdb) {
						resultGuideBeanList.add(gbd);
					}
				} // fin no hay error

			} // fin SDI

			//
			result.setGuideBeanList(resultGuideBeanList);

		} catch (Exception e) {
			YaEstaLog yaestalog = new YaEstaLog();
			yaestalog.setLogDate(new Date());
			yaestalog.setProcessName("WAYBILL-TCC");
			yaestalog.setTextinfo("Error " + e.getMessage());
			yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
			logService.save(yaestalog);
			systemOut.println("Error TCC" + e.getMessage());
			result.setResponse("ERROR");
			e.printStackTrace();
		}

		return result;

	}

	private String getAdjCode() {
		String code = tableSequenceService.getNextValue("SEQ_TCC_ADJ") + "";

		while (code.length() < 7) {
			code = "0" + code;
		}

		return code;
	}

	protected String getLoteCode() {
		String code = tableSequenceService.getNextValue("SEQ_LOTE_TCC") + "";

		while (code.length() < 5) {
			code = "0" + code;
		}

		return code;
	}

	protected String[] determineDocumentType(String document) {
		String result[] = new String[3];
		if (document != null) {
			if (document.length() == 10) {
				result[0] = "CC";
				result[1] = "N";
			} else if (document.length() == 13) {
				result[0] = "NIT";
				result[1] = "J";
			} else {
				result[0] = "CC"; //PAS validar TCC
				result[1] = "N";
			}
		} else {
			result[0] = "N/A";
			result[1] = "N/A";

		}

		return result;
	}

	protected String formatProductValue(Double value) {
		String result = "0";

		if (value != null) {
			value = value * 100;

			result = value.toString();
			result = result.replaceAll("\\.", "");
			result = result.replaceAll(",", "");
		}
		return result;
	}

	/**
	 * Metodo para grabar el log de lo que se envia a TCC en un archivo
	 * 
	 * @param jsonLog
	 */
	// private void buildLog(String jsonLog, String orderId, String sufix){
	private void buildLog(Object grabarDespacho, String orderId, String sufix) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			// Object oJson = sufix != null ? mapper.readValue(jsonLog,
			// GrabarDespacho4Response.class) : mapper.readValue(jsonLog,
			// GrabarDespacho4.class);
			String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(grabarDespacho);
			String fileName = yaestaLogPath + yaestaPrefixTcc + orderId + "_" + (new Date()).getTime() + ".txt";

			if (sufix != null) {
				fileName = yaestaLogPath + yaestaPrefixTcc + "_" + sufix + "_" + orderId + "_" + (new Date()).getTime()
						+ ".txt";
			}

			FileUtils.writeStringToFile(new File(fileName), indented);
			// System.out.println("ObjTCC==>>"+jsonLog);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public TCCTraceVO tccTraceByOrder(String orderId) {
		TCCTraceVO result = new TCCTraceVO();

		List<RemesaEstados> remesaEstadoList = new ArrayList<RemesaEstados>();
		List<Order> queryOrders = orderRepository.findByVitexId(orderId);

		Order order = null;

		if (queryOrders != null && !queryOrders.isEmpty()) {
			order = queryOrders.get(0);
		}

		if (order != null) {

			List<Guide> guides = guideRepository.findByOrder(order);

			if (guides != null && !guides.isEmpty()) {
				for (Guide guide : guides) {

					if (guide.getDeliveryName().equals("TCC")) {
						ConsultarInformacionRemesasEstadosResponse cier = objectFactory
								.createConsultarInformacionRemesasEstadosResponse();
						ConsultarInformacionRemesasEstados cie = objectFactory
								.createConsultarInformacionRemesasEstados();
						cie.setClave(tccServicePassword);
						ArrayOfRemesa aor = objectFactory.createArrayOfRemesa();
						Remesa re = objectFactory.createRemesa();
						re.setNumeroremesa(guide.getGuideNumber());
						aor.getRemesa().add(re);
						cie.setRemesas(aor);

						cier = (ConsultarInformacionRemesasEstadosResponse) webServiceTemplateTCC.marshalSendAndReceive(
								"http://clientes.tcc.com.co/servicios/informacionremesas.asmx", cie,
								new SoapActionCallback(
										"http://clientes.tcc.com.co/ConsultarInformacionRemesasEstados"));

						ArrayOfRemesaEstados aore = cier.getRemesasrespuesta();
						if (aore != null) {
							remesaEstadoList.addAll(aore.getRemesaEstados());
						}
					}

				}
			}
		}
		result.setRemesaEstadoList(remesaEstadoList);

		return result;
	}

	/**
	 * 
	 * @param guideNumber
	 * @return
	 */
	public TCCTraceVO tccTraceByGuide(String guideNumber) {
		TCCTraceVO result = new TCCTraceVO();

		List<RemesaEstados> remesaEstadoList = new ArrayList<RemesaEstados>();

		List<Guide> guideQuery = guideRepository.findByGuideNumber(guideNumber);

		Guide guide = null;

		if (guideQuery != null && !guideQuery.isEmpty()) {
			guide = guideQuery.get(0);
		}

		if (guide != null) {
			if (guide.getDeliveryName().equals("TCC")) {
				ConsultarInformacionRemesasEstadosResponse cier = objectFactory
						.createConsultarInformacionRemesasEstadosResponse();
				ConsultarInformacionRemesasEstados cie = objectFactory.createConsultarInformacionRemesasEstados();
				cie.setClave(tccServicePassword);
				ArrayOfRemesa aor = objectFactory.createArrayOfRemesa();
				Remesa re = objectFactory.createRemesa();
				re.setNumeroremesa(guide.getGuideNumber());
				aor.getRemesa().add(re);
				cie.setRemesas(aor);

				cier = (ConsultarInformacionRemesasEstadosResponse) webServiceTemplateTCC.marshalSendAndReceive(
						"http://clientes.tcc.com.co/servicios/informacionremesas.asmx", cie,
						new SoapActionCallback("http://clientes.tcc.com.co/ConsultarInformacionRemesasEstados"));

				ArrayOfRemesaEstados aore = cier.getRemesasrespuesta();
				if (aore != null) {
					remesaEstadoList.addAll(aore.getRemesaEstados());
				}
			}

		}
		result.setRemesaEstadoList(remesaEstadoList);

		return result;
	}

}
