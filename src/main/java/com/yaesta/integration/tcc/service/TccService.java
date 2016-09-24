package com.yaesta.integration.tcc.service;


import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.entity.CoberturaTCC;
import com.yaesta.app.persistence.service.CoberturaTCCService;
import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.app.persistence.service.YaEstaLogService;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;
import com.yaesta.integration.vitex.json.bean.Dimension;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;
import com.yaesta.integration.base.enums.DeliveryEnum;
import com.yaesta.integration.base.util.BaseUtil;
import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.tcc.wsdl.ObjectFactory;
import com.yaesta.integration.tcc.wsdl.TpDocumentoReferencia;
import com.yaesta.integration.tcc.wsdl.TpGrabarRemesaCompleta;
import com.yaesta.integration.tcc.wsdl.TpUnidad;

@Service
public class TccService  {

	

	//@Autowired
	//private WebServiceTemplate webServiceTemplateTCC;
	
	@Autowired
	YaEstaLogService logService;
	
	@Autowired
	CoberturaTCCService coberturaTccService;
	
	@Autowired
	TableSequenceService tableSequenceService;
	
	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
   
	public JAXBContext context=JAXBContext.newInstance();
	
	public ObjectFactory objectFactory =new ObjectFactory();
	

	protected @Value("${tcc.service.user}") String tccServiceUser;
	protected @Value("${tcc.service.password}") String tccServicePassword;
	protected @Value("${tcc.service.pdf.path}") String tccServicePdfPath;
	protected @Value("${tcc.service.business.unit}") String tccBusinessUnit;
	protected @Value("${tcc.service.business.account}") String tccBusinessAccount;
	protected @Value("${tcc.service.clase.empaque}") String tccServiceClaseEmpaque;
	protected @Value("${tcc.service.tipo.unidad}") String tccServiceTipoUnidad;
	protected @Value("${yaesta.ruc}") String yaestaRuc;
	protected @Value("${datil.iva.value}") String datilIvaValue;
	protected @Value("${datil.iva.percent.value}") String datilIvaPercentValue;
	
	public TccService() throws Exception{}
	
	public GuideDTO generateGuides(GuideDTO guideInfo){
		
		GuideDTO result = new GuideDTO();
		
		try{
			
			
			//String response = "OK";
			
			for(SupplierDeliveryInfo sdi:guideInfo.getOrderComplete().getSupplierDeliveryInfoList()){
			
				List<String> errorInfo = SupplierUtil.validateSupplierInfo(sdi.getSupplier());
				
				if(errorInfo.isEmpty() && sdi.getSelected() && sdi.getDelivery()!=null && sdi.getDelivery().getNemonic().equals(DeliveryEnum.TCC.getNemonic())){
					TpGrabarRemesaCompleta objDespacho = objectFactory.createTpGrabarRemesaCompleta();
					
					objDespacho.setClave(tccServicePassword);
					objDespacho.setFechahoralote(UtilDate.fromDateToString(new Date()));
					objDespacho.setUnidadnegocio(tccBusinessUnit);
					objDespacho.setFechadespacho(UtilDate.fromDateToString(new Date()));
					objDespacho.setCuentaremitente(tccBusinessUnit);
					objDespacho.setDirecciondestinatario(guideInfo.getOrderComplete().getShippingData().getAddress().getStreet());
					
					String province =guideInfo.getOrderComplete().getShippingData().getAddress().getState().toUpperCase();
					String canton = guideInfo.getOrderComplete().getShippingData().getAddress().getCity().toUpperCase();
					String parroquia = canton;
					List<CoberturaTCC> coberturaTccList = coberturaTccService.findByProvinciaCantonParroquia(province, canton, parroquia);
					
					if(coberturaTccList!= null && !coberturaTccList.isEmpty()){
						objDespacho.setCiudaddestinatario(coberturaTccList.get(0).getParroquia());
					}
					
					objDespacho.setPrimernombredestinatario(guideInfo.getOrderComplete().getClientProfileData().getFirstName());
					objDespacho.setPrimerapellidodestinatario(guideInfo.getOrderComplete().getClientProfileData().getLastName());
					objDespacho.setIdentificaciondestinatario(guideInfo.getOrderComplete().getClientProfileData().getDocument());
					objDespacho.setTelefonodestinatario(guideInfo.getOrderComplete().getClientProfileData().getPhone());
					objDespacho.setNaturalezadestinatario("N");  //confirmar
					objDespacho.setTipoidentificaciondestinatario("NIT"); //confirmar
					
					objDespacho.setGenerarDocumentos(true);
					
					String formaPago = "N/A";
					if(guideInfo.getOrderComplete().getPaymentData().getTransactions()!=null && !guideInfo.getOrderComplete().getPaymentData().getTransactions().isEmpty()){
						for(Transaction tr:guideInfo.getOrderComplete().getPaymentData().getTransactions()){
							if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
								for(Payment py:tr.getPayments()){
									formaPago = py.getPaymentSystemName();
									if(py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())){
										formaPago = formaPago + ": " + PagoEnum.EFECTIVO.getDescripcionSRI();
									}else if(py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())){
										formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
									}else if(py.getPaymentSystemName().equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())){
										formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
									}
									else if(py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())){
										formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())){
										formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())){
										formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
									}
									else if(py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())){
										formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_INTERNACIONAL.getDescripcionSRI();
									}
									
								}//fin for
								
							}//
						}
					}
					
					Double deliveryPayment = 0D;
					Boolean hasAdjunto = false;
					if(guideInfo.getOrderComplete().getPaymentData().getTransactions()!=null && !guideInfo.getOrderComplete().getPaymentData().getTransactions().isEmpty()){
						for(Transaction tr:guideInfo.getOrderComplete().getPaymentData().getTransactions()){
							if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
								for(Payment py:tr.getPayments()){
									if(py.getPaymentSystemName().trim().toLowerCase().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName().toLowerCase())){
										hasAdjunto = true; 
										deliveryPayment = deliveryPayment+py.getValue();
									}
								}//fin for
								
							}//
						}
					}//fin payment data
					
					String observacionText = "Orden: "+ guideInfo.getOrderComplete().getOrderId() + " de " + guideInfo.getOrderComplete().getCustomerName() + " " + guideInfo.getOrderComplete().getClientProfileData().getDocument() + " \n " ;
					observacionText = observacionText + "Forma de Pago: "+formaPago;
					
					if(guideInfo.getCustomerAdditionalInfo()!=null && !guideInfo.getCustomerAdditionalInfo().equals("")){
						observacionText = observacionText + "Referencia"+  guideInfo.getCustomerAdditionalInfo();
					}
					
					objDespacho.setObservaciones(observacionText);
					objDespacho.setFormapago(formaPago);
					
					//destinatario
					objDespacho.setPrimerapellidoremitente(sdi.getSupplier().getName() + " - ");
					objDespacho.setPrimerapellidoremitente(sdi.getSupplier().getContactName() + " " + sdi.getSupplier().getContactLastName());
					objDespacho.setDireccionremitente(sdi.getSupplier().getAddress());
					objDespacho.setTelefonoremitente(sdi.getSupplier().getPhone());
					
					//Items
					Long ite = new Long(1);
					Double itemValue =0D;
					Double deliveryCost=0D;
					Double totalValue = 0D;
					Double totalAsegurado = 0D;
					String desc = "";
					TpUnidad unidad = new TpUnidad();
					for(ItemComplete ic:sdi.getItems())
					{
						itemValue =0D;
						System.out.println("Ite==>> "+ite);
						ite++;
						Dimension dim = (Dimension) ic.getAdditionalProperties().get("dimension");
					     	
						if(dim!=null){
							unidad.setAlto(dim.getHeight()+"");
							unidad.setAncho(dim.getWidth()+"");
							unidad.setLargo(dim.getLength()+"");
							unidad.setPesovolumen(dim.getWeight()+"");
						}
						else{
							unidad.setAlto("0");
							unidad.setAncho("0");
							unidad.setLargo("0");
							unidad.setPesovolumen("0");
						}
						
						if(sdi.getItemIdentityType()!=null && sdi.getItemIdentityType().getNemonic().equals("NOMBREPRODUCTO")){
							desc = desc + "#Can. " + ic.getQuantity()+ " PRO:"+ ic.getName()+" _ ";
						}else{
						String[] supplierCodes = SupplierUtil.returnSupplierCode((String)ic.getRefId());
						desc = desc + "#Can. " + ic.getQuantity()+ " COD:"+ supplierCodes[2]+" _ ";
						}
						
						if(desc.length()>250){
							desc=desc.substring(0, 250);
						}
						
						unidad.setDicecontener(desc);
						unidad.setTipounidad(tccServiceTipoUnidad);
						unidad.setClaseempaque(tccServiceClaseEmpaque);
						
						objDespacho.getUnidad().add(unidad);
						
						
						itemValue = itemValue+ic.getPrice()*ic.getQuantity();
						itemValue = (double) Math.round(itemValue * 100) / 100;
						//System.out.println("1> "+itemValue+ " "+totalValue);
						Double discount=0D;
						Boolean hasTax = Boolean.FALSE;
						if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
							for(PriceTag pt:ic.getPriceTags()){
								if(pt.getName().contains("discount@price")){
									Double val= pt.getValue();
									if(val<0){
										val = val* (-1);
									}
								    val = (double) Math.round(val * 100) / 100;
								    discount=discount+Math.abs(val);
									//break;
								}
								if(pt.getName().contains("DISCOUNT@MARKETPLACE"))
								{
									Double val= pt.getValue();
									if(val<0){
										val = val* (-1);
									}
								    val = (double) Math.round(val * 100) / 100;
								    discount=discount+Math.abs(val);
								}
								if(pt.getName().contains("tax@price")){
									hasTax=Boolean.TRUE;
								}
							}
						}else{
							discount=0D;
						}
						
						if(ic.getShippingPrice()!=null){
							System.out.println("shippingPrice "+ ic.getShippingPrice());
							unidad.setValormercancia(ic.getShippingPrice()+"");
							deliveryCost = deliveryCost+ic.getShippingPrice();
						}else{
							System.out.println("Sin costo de cobro de envio");
							//carga.setValorCobro(0D);
						}
						Double iva = 0D;
						totalAsegurado = totalAsegurado + itemValue;
						totalAsegurado = (double) Math.round(totalAsegurado * 100) / 100;
						itemValue = itemValue - discount;
						itemValue = (double) Math.round(itemValue * 100) / 100;
						
						//System.out.println("2> "+itemValue+ " "+totalValue);
						
						if(ic.getTax()>0){
							iva=ic.getTax();
						}else{
							if(hasTax){
								iva=BaseUtil.calculateIVA(itemValue,new Integer(datilIvaValue),datilIvaPercentValue);
							}
						}
						if(itemValue.intValue()>0){
							itemValue = itemValue + iva;
						}
						itemValue = (double) Math.round(itemValue * 100) / 100;
						
						//System.out.println("3> "+itemValue+ " "+totalValue);
						totalValue = totalValue+itemValue;
						totalValue = (double) Math.round(totalValue * 100) / 100;
						if(hasAdjunto && itemValue.intValue()>0){
							
							TpDocumentoReferencia docReferencia = new TpDocumentoReferencia();
							
							String codigoAdjunto =  getAdjCode();
							System.out.println("Codigo Adjunto "+codigoAdjunto);
							docReferencia.setNumerodocumento(codigoAdjunto);
							docReferencia.setTipodocumento("FA"); //confirmar
							
							objDespacho.getDocumentoreferencia().add(docReferencia);
						}else{
							
							System.out.println("No hay adjunto");
						}
						
						
						objDespacho.setTotalvalormercancia(totalAsegurado+"");
						objDespacho.setCodigolote(guideInfo.getOrderComplete().getOrderId());
					
					}//for de items
					
				
				}
			
			}
		}catch(Exception e){
			YaEstaLog yaestalog = new YaEstaLog();
			yaestalog.setLogDate(new Date());
			yaestalog.setProcessName("WAYBILL-TCC");
			yaestalog.setTextinfo(guideInfo.getOrderComplete().getOrderId());
			yaestalog.setTextinfo("Error "+e.getMessage());
			yaestalog.setOrderId(guideInfo.getOrderComplete().getOrderId());
			logService.save(yaestalog);
		}
		
		return result;
		
	}
	
	private String getAdjCode(){
		String code = tableSequenceService.getNextValue("SEQ_TCC_ADJ")+"";
		
		if(code.length()<7){
			code = "0"+code;
		}
		
		return code;
	}

}
