package com.yaesta.integration.tramaco.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.dto.TramacoAuthDTO;
import com.yaesta.integration.vitex.json.bean.Dimension;
import com.yaesta.integration.vitex.json.bean.ItemComplete;

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
public class TramacoService {

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	TableSequenceService tableSequenceService;

	private @Value("${tramaco.url}") String tramacoUrl;
	private @Value("${tramaco.port}") String tramacoPort;
	private @Value("${tramaco.user}") String tramacoUser;
	private @Value("${tramaco.password}") String tramacoPassword;
	private @Value("${tramaco.pdf.path}") String tramacoPdfPath;
	private @Value("${tramaco.default.document}") String tramacoDefaultDocument;
	private @Value("${yaesta.ruc}") String yaestaRuc;

	public TramacoAuthDTO authService(){

		TramacoAuthDTO tramacoAuth = new TramacoAuthDTO();
		String response = "ok";
		
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
		
		String response = "ok";
		
		//Autenticar
		TramacoAuthDTO tramacoAuth = authService();
		
		if(response.equals(tramacoAuth.getResponse())){
			String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
			//Obtener informacion para la guia
			ServicioGenerarGuias cliente = new ServicioGenerarGuias(url);
			/**
			* Datos de entrada
			*/
			EntradaGenerarGuiaWs entGen = new EntradaGenerarGuiaWs();
			//***********/
			EntityActor remitente = new EntityActor();
			remitente.setApellidos(guideInfo.getSupplierInfo().getSupplier().getContactLastName());
			remitente.setCallePrimaria(guideInfo.getSupplierInfo().getSupplier().getStreetMain());
			remitente.setCalleSecundaria(guideInfo.getSupplierInfo().getSupplier().getStreetSecundary());
			remitente.setCiRuc(yaestaRuc);
			//if(guideInfo.getSupplierInfo().getSupplier().getPostalCode()!=null){
				//remitente.setCodigoPostal(new Integer(guideInfo.getSupplierInfo().getSupplier().getPostalCode()));
			//}else
			//{
				remitente.setCodigoPostal(468); //only for test
			//}
			
			remitente.setEmail(guideInfo.getSupplierInfo().getSupplier().getContactEmail());
			remitente.setNombres(guideInfo.getSupplierInfo().getSupplier().getContactName());
			remitente.setNumero(guideInfo.getSupplierInfo().getSupplier().getStreetNumber());
			remitente.setReferencia(guideInfo.getSupplierInfo().getSupplier().getAddressReference());
			remitente.setTelefono(guideInfo.getSupplierInfo().getSupplier().getPhone());
			remitente.setTipoIden("04");
			//*****//
			List<EntityCargaDestino> lstCargaDestino = new ArrayList<>();
			//................................TRANSACCION 1.........................................//
			
			for(ItemComplete ic:guideInfo.getSupplierInfo().getDeliveryInfo().getItemList())
			{
				EntityCargaDestino entCargaDestino = new EntityCargaDestino();
				entCargaDestino.setId(tableSequenceService.getNextValue("CARGA_DESTINO").intValue());
				//*******//
				EntityCarga carga = new EntityCarga();
				//carga.
				
				Dimension dim = (Dimension) ic.getAdditionalProperties().get("dimension");
				
				if(dim!=null){
					carga.setAlto(dim.getHeight());
					carga.setAncho(dim.getWidth());
					carga.setLargo(dim.getLength());
					carga.setPeso(dim.getWeight());
				}
				carga.setBultos(guideInfo.getSupplierInfo().getDeliveryInfo().getPackages().intValue());
				//carga.setCajas(5);
				//carga.setCantidadDoc(1);
				//carga.setContrato(tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getLstContrato().get(0).getId());
				carga.setDescripcion("descripcion");
				
				carga.setProducto(12);
				//carga.setValorAsegurado(9.0);
				carga.setAdjuntos(Boolean.FALSE);
				carga.setLocalidad(0);
				carga.setGuia(guideInfo.getOrderComplete().getOrderId());
				entCargaDestino.setCarga(carga);
				//******//
				EntityActor destinatario = new EntityActor();
				destinatario.setApellidos(guideInfo.getOrderComplete().getClientProfileData().getLastName());
				destinatario.setCallePrimaria(guideInfo.getOrderComplete().getShippingData().getAddress().getStreet());
				destinatario.setCalleSecundaria((String)guideInfo.getOrderComplete().getShippingData().getAddress().getComplement());
				
				if(guideInfo.getOrderComplete().getClientProfileData().getDocument()!=null){
					destinatario.setCiRuc(guideInfo.getOrderComplete().getClientProfileData().getDocument());
				}else{
					destinatario.setCiRuc(tramacoDefaultDocument);
				}
				//destinatario.setCiRuc(tramacoDefaultDocument);
				destinatario.setTipoIden("05");
				
				//if(guideInfo.getOrderComplete().getShippingData().getAddress().getPostalCode()!=null){
				//	destinatario.setCodigoPostal(new Integer(guideInfo.getOrderComplete().getShippingData().getAddress().getPostalCode()));
			//	}
				//else{
					destinatario.setCodigoPostal(689); //only for test
			//	}
				destinatario.setEmail(guideInfo.getOrderComplete().getClientProfileData().getEmail());
				destinatario.setNombres(guideInfo.getOrderComplete().getClientProfileData().getFirstName());
				destinatario.setNumero(guideInfo.getOrderComplete().getShippingData().getAddress().getNumber());
				destinatario.setReferencia((String)guideInfo.getOrderComplete().getShippingData().getAddress().getReference());
				destinatario.setTelefono(guideInfo.getOrderComplete().getClientProfileData().getPhone());
				
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
			
			}
			
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
				}
				if (respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs() != null) {
					SalidaGenerarGuiaWs salida = respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs();
					for (EntityGuia guia : salida.getLstGuias()) {
						System.out.println("ID:" + guia.getId() + " GUIA:" + guia.getGuia());
					}	
				}
				guideInfo.setGuideResponse(respuestaGenerarGuiaWs);
				guideInfo.getGuideResponse().setSalidaGenerarGuiaWs(respuestaGenerarGuiaWs.getSalidaGenerarGuiaWs());
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
		
		String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
		
		String response = "ok";
		
		//Autenticar
		TramacoAuthDTO tramacoAuth = authService();
		
		if(response.equals(tramacoAuth.getResponse())){
		
			ServicioGenerarPdf cliente = new ServicioGenerarPdf(url);
			/**
			 * Datos de entrada
			 */
			EntradaGenerarPdfWs entGen = new EntradaGenerarPdfWs();
			entGen.setUsuario(tramacoAuth.getRespuestaAutenticarWs().getSalidaAutenticarWs().getUsuario());
			//***********/
			List<EntityGuia> lstGuia = new ArrayList<>();
		
			//EntityGuia entityGuia = new EntityGuia(2, guideInfo.getGuide().getVitexDispatcherId());
			EntityGuia entityGuia = new EntityGuia(18, "031002000386208");
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
					SalidaGenerarPdfWs salida = respuestaGenerarPdfWs.getSalidaGenerarPdfWs();
					if (salida.getInStrPfd() != null) {
						String location = tramacoPdfPath +"/GuiaPdf-" + (new Date()).getTime()+ "-" + guideInfo.getGuide().getVitexDispatcherId() +"-" + guideInfo.getGuide().getOrderVitexId() + ".pdf";
						FileOutputStream out;
						try {
							out = new FileOutputStream(location);
							try (InputStream is = salida.getInStrPfd()) {
								int len;
								byte[] buffer = new byte[4096];
								while ((len = is.read(buffer)) != -1) {
									out.write(buffer, 0, len);
								}
								out.flush();
								out.close();
							}
						} catch (IOException ex) {
							System.out.println(ex);
						}
					  guideInfo.setPdfUrl(location);
					  guideInfo.setGuidePdfResponse(respuestaGenerarPdfWs);
					}
					
				}
			}
		}else{
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
		
		String response = "ok";
		
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
}
