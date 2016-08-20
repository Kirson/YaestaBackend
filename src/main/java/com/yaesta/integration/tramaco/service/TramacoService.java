package com.yaesta.integration.tramaco.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.repository.TramacoZoneRepository;
import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.integration.base.util.BaseUtil;
import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.dto.TramacoAuthDTO;
import com.yaesta.integration.vitex.json.bean.Dimension;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;


import dmz.comercial.servicio.cliente.dto.EntityActor;
import dmz.comercial.servicio.cliente.dto.EntityCarga;
import dmz.comercial.servicio.cliente.dto.EntityCargaDestino;
import dmz.comercial.servicio.cliente.dto.EntityContrato;
import dmz.comercial.servicio.cliente.dto.EntityGuia;
import dmz.comercial.servicio.cliente.dto.EntityLocalidad;
import dmz.comercial.servicio.cliente.dto.EntityProducto;
import dmz.comercial.servicio.cliente.dto.EntityServicio;
import dmz.comercial.servicio.cliente.dto.EntradaAutenticarWs;
import dmz.comercial.servicio.cliente.dto.EntradaGenerarGuiaWs;
import dmz.comercial.servicio.cliente.dto.EntradaGenerarPdfWs;
import dmz.comercial.servicio.cliente.dto.EntradaTrackGuiaWs;
import dmz.comercial.servicio.cliente.dto.RespuestaAutenticarWs;
import dmz.comercial.servicio.cliente.dto.RespuestaGenerarGuiaWs;
import dmz.comercial.servicio.cliente.dto.RespuestaGenerarPdfWs;
import dmz.comercial.servicio.cliente.dto.RespuestaTrackGuiaWs;
import dmz.comercial.servicio.cliente.dto.SalidaAutenticarWs;
import dmz.comercial.servicio.cliente.dto.SalidaGenerarGuiaWs;
import dmz.comercial.servicio.cliente.dto.SalidaGenerarPdfWs;
import dmz.comercial.servicio.cliente.dto.SalidaTrackGuiaWs;
import dmz.comercial.servicio.cliente.impl.ServicioAutenticar;
import dmz.comercial.servicio.cliente.impl.ServicioGenerarGuias;
import dmz.comercial.servicio.cliente.impl.ServicioGenerarPdf;
import dmz.comercial.servicio.cliente.impl.ServicioTrackingGuia;

@Service
public class TramacoService implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 8403748444468007479L;

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	TableSequenceService tableSequenceService;
	
	@Autowired
	TramacoZoneRepository tramacoZoneRepository;

	private @Value("${tramaco.url}") String tramacoUrl;
	private @Value("${tramaco.port}") String tramacoPort;
	private @Value("${tramaco.user}") String tramacoUser;
	private @Value("${tramaco.password}") String tramacoPassword;
	private @Value("${tramaco.pdf.path}") String tramacoPdfPath;
	private @Value("${tramaco.default.document}") String tramacoDefaultDocument;
	private @Value("${yaesta.ruc}") String yaestaRuc;
	private @Value("${datil.iva.value}") String datilIvaValue;
	private @Value("${datil.iva.percent.value}") String datilIvaPercentValue;

	public TramacoAuthDTO authService(){

		TramacoAuthDTO tramacoAuth = new TramacoAuthDTO();
		String response = "OK";
		
		System.out.println("Inicio auhtService"); 

		try{
			String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
			//System.out.println("URL:"+url); 
			//System.out.println("USER:"+tramacoUser);
			//System.out.println("PASSWORD:"+tramacoPassword);
			ServicioAutenticar client = new ServicioAutenticar(url);
			

			/**
			 * Datos de entrada
			 */
			EntradaAutenticarWs entAut = new EntradaAutenticarWs();
			entAut.setLogin(tramacoUser);
			entAut.setPassword(tramacoPassword);
			/*Consumo*/
			RespuestaAutenticarWs respuestaAutenticarWs = client.autenticarCliente(entAut);

			/**
			 * Datos de salida
			 */
			if (respuestaAutenticarWs != null) {
				if (respuestaAutenticarWs.getCuerpoRespuesta() != null) {
					System.out.println("CODIGO:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getCodigo());
					System.out.println("MENSAJE:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getMensaje());
					System.out.println("EXCEPCION:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getExcepcion());
				}
				if (respuestaAutenticarWs.getSalidaAutenticarWs() != null) {
					SalidaAutenticarWs salida = respuestaAutenticarWs.getSalidaAutenticarWs();
					System.out.println("CONTRATOS:");
					for (EntityContrato contrato : salida.getLstContrato()) {
						System.out.println("ID:" + contrato.getId() + " NUMERO:" + contrato.getNumero());
					}
					System.out.println("LOCALIDADES:");
					for (EntityLocalidad localidad : salida.getLstLocalidad()) {
						System.out.println("ID:" + localidad.getId() + " NOMBRE:" +
								localidad.getNombre());
					}
					System.out.println("PRODUCTOS:");
					for (EntityProducto producto : salida.getLstProducto()) {
						System.out.println("ID:" + producto.getId() + " NOMBRE:" + producto.getNombre()
						+ " TIPO:" + producto.getTipo());
					}
					System.out.println("SERVICIOS:");
					for (EntityServicio servicio : salida.getLstServicio()) {
						System.out.println("ID:" + servicio.getId() + " NOMBRE:" + servicio.getNombre() +
								" TIPO:" + servicio.getTipo());
					}
				}
				tramacoAuth.setRespuestaAutenticarWs(respuestaAutenticarWs);
			}

		}catch(Exception e){

			System.out.println("Error al consumir servicio tramaco Auth");

			response= "error";
		}
		
		tramacoAuth.setResponse(response);

		return tramacoAuth;
	}
	
		/**
	 * Servicio para generacion de guias
	 * @param guideInfo
	 * @return
	 */
	public GuideDTO generateGuide(GuideDTO guideInfo){
		
		String response = "OK";
		
		//Autenticar
		TramacoAuthDTO tramacoAuth = authService();
		
		if(response.equals(tramacoAuth.getResponse())){
			
			List<String> errorInfo = this.validateSupplierInfo(guideInfo.getSupplierInfo().getSupplier());
			
			if(errorInfo.isEmpty()){
			String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
			//Obtener informacion para la guia
			ServicioGenerarGuias cliente = new ServicioGenerarGuias(url);
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
			
			String observacionText = "Orden: "+ guideInfo.getOrderComplete().getOrderId() + " de " + guideInfo.getOrderComplete().getCustomerName() + " " + guideInfo.getOrderComplete().getClientProfileData().getDocument() + " \n " ;
			observacionText = observacionText + "Forma de Pago: "+formaPago;
			
			if(guideInfo.getCustomerAdditionalInfo()!=null && !guideInfo.getCustomerAdditionalInfo().equals("")){
				observacionText = observacionText + "Referencia"+  guideInfo.getCustomerAdditionalInfo();
			}
		   /**
			* Datos de entrada
			*/
			EntradaGenerarGuiaWs entGen = new EntradaGenerarGuiaWs();
			
	
			
			//***********/
			EntityActor remitente = new EntityActor();
			remitente.setNombres(guideInfo.getSupplierInfo().getSupplier().getName() + " - ");
			remitente.setApellidos(guideInfo.getSupplierInfo().getSupplier().getContactName() + " " + guideInfo.getSupplierInfo().getSupplier().getContactLastName());
			remitente.setCallePrimaria(guideInfo.getSupplierInfo().getSupplier().getStreetMain());
			remitente.setCalleSecundaria(guideInfo.getSupplierInfo().getSupplier().getStreetSecundary());
			remitente.setCiRuc(yaestaRuc);
			if(guideInfo.getSupplierInfo().getSupplier().getPostalCode()!=null){
				remitente.setCodigoPostal(new Integer(guideInfo.getSupplierInfo().getSupplier().getPostalCode()));
			}
			
			
			
			
			remitente.setEmail(guideInfo.getSupplierInfo().getSupplier().getContactEmail());
			
			if(guideInfo.getSupplierInfo().getSupplier().getStreetNumber()==null){
				remitente.setNumero("SN");
			}else{
				remitente.setNumero(guideInfo.getSupplierInfo().getSupplier().getStreetNumber());
			}
			
			if(guideInfo.getSupplierInfo().getSupplier().getAddressReference()==null){
				remitente.setReferencia(guideInfo.getSupplierInfo().getSupplier().getAddressReference());
			}else{
				remitente.setReferencia("");
			}
			if(guideInfo.getSupplierInfo().getSupplier().getPhone()==null){
				remitente.setTelefono(guideInfo.getSupplierInfo().getSupplier().getPhone());
			}else{
				remitente.setTelefono("         ");
			}
			remitente.setTipoIden("04");
			
			Double deliveryCost = 0D;
			Double deliveryPayment = 0D;
			Double itemValue = 0D;
			Boolean hasAdjunto = false;
			if(guideInfo.getOrderComplete().getPaymentData().getTransactions()!=null && !guideInfo.getOrderComplete().getPaymentData().getTransactions().isEmpty()){
				for(Transaction tr:guideInfo.getOrderComplete().getPaymentData().getTransactions()){
					if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
						for(Payment py:tr.getPayments()){
							if(py.getPaymentSystemName().trim().toLowerCase().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName().toLowerCase())){
								hasAdjunto = true; 
								//System.out.println("Si debe tener adjunto");
								deliveryPayment = deliveryPayment+py.getValue();
							}
						}//fin for
						
					}//
				}
			}
			
			
			
			//*****//
			List<EntityCargaDestino> lstCargaDestino = new ArrayList<>();
			//................................TRANSACCION 1.........................................//
	
			EntityCargaDestino entCargaDestino = new EntityCargaDestino();
			entCargaDestino.setId(tableSequenceService.getNextValue("CARGA_DESTINO").intValue());
			//*******//
			EntityCarga carga = new EntityCarga();
			carga.setBultos(guideInfo.getSupplierInfo().getDeliveryInfo().getPackages().intValue());
			
			String desc = "";
			Long ite = new Long(1);
			for(ItemComplete ic:guideInfo.getSupplierInfo().getDeliveryInfo().getItemList())
			{
				System.out.println("Ite==>> "+ite);
				ite++;
				Dimension dim = (Dimension) ic.getAdditionalProperties().get("dimension");
				
				if(dim!=null){
					carga.setAlto(dim.getHeight());
					carga.setAncho(dim.getWidth());
					carga.setLargo(dim.getLength());
					carga.setPeso(dim.getWeight());
				}
				else{
					carga.setAlto(0D);
					carga.setAncho(0D);
					carga.setLargo(0D);
					carga.setPeso(0D);
				}
				Integer contrato = 0;
				for(EntityContrato entityContrato:tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getLstContrato()){
					contrato = entityContrato.getId();
					if(contrato==2977){
						break;
					}
				}
				carga.setContrato(contrato);
				desc = desc + " " + ic.getName();
				carga.setDescripcion(ic.getName());
				carga.setObservacion(observacionText);
				
				
				itemValue = itemValue+ic.getPrice()*ic.getQuantity();
				itemValue = (double) Math.round(itemValue * 100) / 100;
				Double discount=0D;
				Boolean hasTax = Boolean.FALSE;
				if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
					for(PriceTag pt:ic.getPriceTags()){
						if(pt.getName().contains("discount@price")){
							Double val= pt.getValue();
							if(val.intValue()<0){
								val = val* (-1);
							}
						    val = (double) Math.round(val * 100) / 100;
						    discount=val;
							//break;
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
					carga.setValorCobro(ic.getShippingPrice());
					deliveryCost = deliveryCost+itemValue;
				}else{
					System.out.println("Sin costo de cobro de envio");
					//carga.setValorCobro(0D);
				}
				Double iva = 0D;
				itemValue = itemValue - discount;
				if(ic.getTax().intValue()>0){
					iva=ic.getTax();
				}else{
					if(hasTax){
						iva=BaseUtil.calculateIVA(itemValue,new Integer(datilIvaValue),datilIvaPercentValue);
					}
				}
				itemValue = itemValue + iva;
				
				if(hasAdjunto){
					carga.setAdjuntos(Boolean.TRUE);
					String codigoAdjunto =  getTramacoAdjCode();
					System.out.println("Codigo Adjunto "+codigoAdjunto);
					carga.setCodigoAdjunto(codigoAdjunto);
					carga.setValorCobro(itemValue);
				}else{
					carga.setAdjuntos(Boolean.FALSE);
					System.out.println("No hay adjunto");
				}
				
				System.out.println("Valor a cobrar" + carga.getValorCobro());
				
				
				carga.setProducto(1);
				carga.setValorAsegurado(itemValue);
				carga.setLocalidad(0);
				carga.setGuia(guideInfo.getOrderComplete().getOrderId());
			
			}
			
			entCargaDestino.setCarga(carga);
			//******//
			EntityActor destinatario = new EntityActor();
			destinatario.setApellidos(guideInfo.getOrderComplete().getClientProfileData().getLastName());
			destinatario.setCallePrimaria(guideInfo.getOrderComplete().getShippingData().getAddress().getStreet());
			if(guideInfo.getOrderComplete().getShippingData().getAddress().getComplement()!=null){
				destinatario.setCalleSecundaria(guideInfo.getOrderComplete().getShippingData().getAddress().getComplement());
			}else{
				destinatario.setCalleSecundaria("");
			}
			if(guideInfo.getOrderComplete().getClientProfileData().getDocument()!=null){
				destinatario.setCiRuc(guideInfo.getOrderComplete().getClientProfileData().getDocument());
			}else{
				destinatario.setCiRuc(tramacoDefaultDocument);
			}
			//destinatario.setCiRuc(tramacoDefaultDocument);
			destinatario.setTipoIden("05");
			
			if(guideInfo.getOrderComplete().getShippingData().getAddress().getCity()!=null){
				String province =guideInfo.getOrderComplete().getShippingData().getAddress().getState().toUpperCase();
				String canton = guideInfo.getOrderComplete().getShippingData().getAddress().getCity().toUpperCase();
				List<TramacoZone> zones = tramacoZoneRepository.findByProvinciaAndCantonAndParroquia(province, canton, canton);
				if(zones!=null && !zones.isEmpty()){
					destinatario.setCodigoPostal(zones.get(0).getCodigo().intValue());
				}
				
			}else if(guideInfo.getOrderComplete().getShippingData().getAddress().getPostalCode()!=null){
				destinatario.setCodigoPostal(new Integer(guideInfo.getOrderComplete().getShippingData().getAddress().getPostalCode()));
			}else{
				destinatario.setCodigoPostal(0);
			}
			
			destinatario.setEmail(guideInfo.getOrderComplete().getClientProfileData().getEmail());
			destinatario.setNombres(guideInfo.getOrderComplete().getClientProfileData().getFirstName());
			destinatario.setNumero(guideInfo.getOrderComplete().getShippingData().getAddress().getNumber());
			if(guideInfo.getOrderComplete().getShippingData().getAddress().getReference()!=null){
				destinatario.setReferencia(guideInfo.getOrderComplete().getShippingData().getAddress().getReference());
			}else{
				destinatario.setReferencia("");
			}
			if(guideInfo.getOrderComplete().getClientProfileData().getPhone()!=null){
				destinatario.setTelefono(guideInfo.getOrderComplete().getClientProfileData().getPhone());
			}else{
				destinatario.setTelefono("         ");
			}
			entCargaDestino.setDestinatario(destinatario);
			//*************//
			List<EntityServicio> lstServicio = new ArrayList<>();
			EntityServicio entServicio = new EntityServicio();
			entServicio.setId(38); //Verificar
			entServicio.setTipo("LIV");
			entServicio.setCantidad(0.0);
			lstServicio.add(entServicio);
			entCargaDestino.setLstServicio(lstServicio);
			
			/********/
			lstCargaDestino.add(entCargaDestino);
			//*******//
			entGen.setRemitente(remitente);
			entGen.setLstCargaDestino(lstCargaDestino);
			entGen.setUsuario( tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getUsuario());  //Verificar
		
			
			/**/
			RespuestaGenerarGuiaWs respuestaGenerarGuiaWs = cliente.generarGuia(entGen);
			/**
			* Datos de salida
			*/
			if (respuestaGenerarGuiaWs != null) {
				if (respuestaGenerarGuiaWs.getCuerpoRespuesta() != null) {
					System.out.println("CODIGO:"	+ respuestaGenerarGuiaWs.getCuerpoRespuesta().getCodigo());
					System.out.println("MENSAJE:"   + respuestaGenerarGuiaWs.getCuerpoRespuesta().getMensaje());
					System.out.println("EXCEPCION:" + respuestaGenerarGuiaWs.getCuerpoRespuesta().getExcepcion());
				   
					if(respuestaGenerarGuiaWs.getCuerpoRespuesta().getCodigo()!="1"){
						response = respuestaGenerarGuiaWs.getCuerpoRespuesta().getMensaje();
						errorInfo.add(response);
					}
				
				}
				if (respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs() != null) {
					SalidaGenerarGuiaWs salida = respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs();
					for (EntityGuia guia : salida.getLstGuias()) {
						System.out.println("ID:" + guia.getId() + " GUIA:" + guia.getGuia());
					}	
				}
				guideInfo.setGuideResponse(respuestaGenerarGuiaWs);
				guideInfo.getGuideResponse().setSalidaGenerarGuiaWs(respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs());
				guideInfo.setDeliveryCost(deliveryCost);
				guideInfo.setDeliveryPayment(deliveryPayment);
				guideInfo.setItemValue(itemValue);
			}
			
			}else{
				response = "Error";
				guideInfo.setErrorList(errorInfo);
				for(String e:errorInfo){
					System.out.println("Problemas en::"+e);
				}
			}
			
		}else{
			response = tramacoAuth.getResponse();
		}
		
		guideInfo.setResponse(response);
		return guideInfo;
	}
	
	/**
	 * Producir  PDF de la GUIA
	 * @param guideInfo
	 * @return
	 */
	public GuideDTO generateGuiaPDF(GuideDTO guideInfo){
		
		
		String response = "OK";
		
		//Autenticar
		TramacoAuthDTO tramacoAuth = authService();
		
		if(response.equals(tramacoAuth.getResponse())){
			
			System.out.println("Esta Auth");
			String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
			
			String[] guidePart = guideInfo.getGuide().getVitexDispatcherId().split("%");
			
		
			ServicioGenerarPdf cliente = new ServicioGenerarPdf(url);
			/**
			 * Datos de entrada
			 */
			EntradaGenerarPdfWs entGen = new EntradaGenerarPdfWs();
			
			System.out.println("URL:" + url);
			
			
			entGen.setUsuario(tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getUsuario());
			//***********/
			List<EntityGuia> lstGuia = new ArrayList<>();
		
			EntityGuia entityGuia = new EntityGuia(new Integer(guidePart[0]), guidePart[1]);
			System.out.println("Guia: "+ guidePart[1]);
			lstGuia.add(entityGuia);
			entGen.setLstGuia(lstGuia);
			
			/**/
			RespuestaGenerarPdfWs respuestaGenerarPdfWs = cliente.generarPdf(entGen);
			/**
			* Datos de salida
			*/
			if (respuestaGenerarPdfWs != null) {
				if (respuestaGenerarPdfWs.getCuerpoRespuesta() != null) {
					System.out.println("CODIGO:" + respuestaGenerarPdfWs.getCuerpoRespuesta().getCodigo());
					System.out.println("MENSAJE:" + respuestaGenerarPdfWs.getCuerpoRespuesta().getMensaje());
					System.out.println("EXCEPCION:" + respuestaGenerarPdfWs.getCuerpoRespuesta().getExcepcion());
				}
				if (respuestaGenerarPdfWs.getSalidaGenerarPdfWs() != null) {
					System.out.println("Esta Tiene salida PDF");
					String location = tramacoPdfPath +"/GuiaPdf-" + (new Date()).getTime()+ "-" + guideInfo.getGuide().getVitexDispatcherId() +"-" + guideInfo.getGuide().getOrderVitexId() + ".pdf";
					System.out.println("location:"+location);
					SalidaGenerarPdfWs salida = respuestaGenerarPdfWs.getSalidaGenerarPdfWs();
					if (salida.getInStrPfd() != null) {
						//String location = tramacoPdfPath +"/GuiaPdf-" + (new Date()).getTime()+ "-" + guideInfo.getGuide().getVitexDispatcherId() +"-" + guideInfo.getGuide().getOrderVitexId() + ".pdf";
						//System.out.println("location:"+location);
						FileOutputStream out;
						try {
							out = new FileOutputStream(location);
							

							
							try (InputStream is = salida.getInStrPfd()) {
								
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								org.apache.commons.io.IOUtils.copy(is, baos);
								InputStream is2 = new ByteArrayInputStream(baos.toByteArray()); 
								
								int len;
								//System.out.println("Hay inputStream");
								
								byte[] buffer = new byte[4096];
								while ((len = is2.read(buffer)) != -1) {
									//System.out.println("++"+new String(buffer));
									out.write(buffer, 0, len);
								}
								out.flush();
								out.close();
							}
						} catch (IOException ex) {
							System.out.println("==>>"+ex);
							ex.printStackTrace();
						}
					  guideInfo.setPdfUrl(location);
					 // System.out.println("location:"+location);
					  guideInfo.setGuidePdfResponse(respuestaGenerarPdfWs);
					}else{
						System.out.println("salida.getInStrPfd() es nulo");
					}
					
				}
				else{
					System.out.println("NO tienes salida");
				}
			}
		
		//
		}else{
			System.out.println("NO es AUTH");
			response = tramacoAuth.getResponse();
		}
		
		guideInfo.setResponse(response);
		return guideInfo;
	}

	/**
	 * Tracking de GUIA
	 * @param guideInfo
	 * @return
	 */
	public GuideDTO trackingService(GuideDTO guideInfo){
		
		String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
		
		String response = "OK";
		
		//Autenticar
		TramacoAuthDTO tramacoAuth = authService();
		
		if(response.equals(tramacoAuth.getResponse())){
			
			ServicioTrackingGuia cliente = new ServicioTrackingGuia(url);
			/**
			* Datos de entrada
			*/
			EntradaTrackGuiaWs entTraGui = new EntradaTrackGuiaWs();
			entTraGui.setUsuario(tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getUsuario());
			entTraGui.setGuia("031002000386207");
			/**/
			RespuestaTrackGuiaWs respuestaTrackGuiaWs = cliente.obtenerTracking(entTraGui);
			/**
			* Datos de salida
			*/
			if (respuestaTrackGuiaWs != null) {
				if (respuestaTrackGuiaWs.getCuerpoRespuesta() != null) {
					System.out.println("CODIGO:"+ respuestaTrackGuiaWs.getCuerpoRespuesta().getCodigo());
					System.out.println("MENSAJE:" +	respuestaTrackGuiaWs.getCuerpoRespuesta().getMensaje());
					System.out.println("EXCEPCION:" +respuestaTrackGuiaWs.getCuerpoRespuesta().getExcepcion());
				}
				if (respuestaTrackGuiaWs.getLstSalidaTrackGuiaWs() != null) {
					for (SalidaTrackGuiaWs trackGuia : respuestaTrackGuiaWs.getLstSalidaTrackGuiaWs()) {
						System.out.println("FECHA_HORA:" + trackGuia.getFechaHora() + " DESCRIPCION:" +trackGuia.getDescripcion());
					}
				}
				guideInfo.setGuideTrackResponse(respuestaTrackGuiaWs);
			}
		}
		
		return guideInfo;
	}
	
	
	private List<String> validateSupplierInfo(Supplier supplier){
		List<String> errorInfoList = new ArrayList<String>();
		
		String supplierName = "Proveedor "+supplier.getName();
		
		if(supplier.getContactEmail()==null){
			errorInfoList.add(supplierName+" no posee email");
		}
		if(supplier.getContactName()==null){
			errorInfoList.add(supplierName+" no posee nombre de contacto");
		}
		if(supplier.getContactLastName()==null){
			errorInfoList.add(supplierName+" no posee apellido de contacto");
		}
		if(supplier.getPostalCode()==null){
			errorInfoList.add(supplierName+" no posee codigo postal");
		}
		
		return errorInfoList;
	}
	
	private String getTramacoAdjCode(){
		String code = tableSequenceService.getNextValue("SEQ_TRAMACO_ADJ")+"";
		
		if(code.length()<7){
			code = "0"+code;
		}
		
		return code;
	}
}
