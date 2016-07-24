package com.yaesta.integration.datil.service;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.datil.json.bean.Comprador;
import com.yaesta.integration.datil.json.bean.Emisor;
import com.yaesta.integration.datil.json.bean.Establecimiento;
import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.json.bean.FacturaSRI;
import com.yaesta.integration.datil.json.bean.Impuesto_;
import com.yaesta.integration.datil.json.bean.Item;
import com.yaesta.integration.datil.json.bean.NotaCredito;
import com.yaesta.integration.datil.json.bean.NotaCreditoRespuesta;
import com.yaesta.integration.datil.json.bean.Totales;
import com.yaesta.integration.vitex.bean.CreditNoteBean;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

@Service
public class DatilService implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	TableSequenceService tableSequenceService;

	private @Value("${datil.api.key}") String datilApiKey;
	private @Value("${datil.webservice.url}") String datilWebServiceUrl;
	private @Value("${datil.webhook.url}") String datilWebhookUrl;
	private @Value("${datil.documents.url}") String datilDocumentsUrl;
	private @Value("${datil.sri.password}") String datilSriPassword;
	private @Value("${datil.enviroment.type}") String datilEnviromentType;
	private @Value("${datil.emission.type}") String datilEmissionType;
	private @Value("${datil.social.reason}") String datilSocialReasson;
	private @Value("${datil.ruc.number}") String datilRucNumber;
	private @Value("${datil.establishment.code}") String datilEstablishmentCode;
	private @Value("${datil.emission.code}") String datilEmissionCode;
	private @Value("${datil.currency.code}") String datilCurrencyCode;
	private @Value("${datil.matrix.address}") String datilMatrixAddress;
	private @Value("${datil.establishment.address}") String datilEstablishmentAddress;
	private @Value("${datil.iva.value}") String datilIvaValue;
	private @Value("${datil.iva.code}") String datilIvaCode;
	private @Value("${datil.iva.code.percent}") String datilIvaCodePercent;
	
	private Client client;
	private WebTarget target;
	
	private FacturaRespuestaSRI invoice(FacturaSRI input){
		FacturaRespuestaSRI response = new FacturaRespuestaSRI();
		
		String restUrl = datilWebServiceUrl + "/invoices/issue";
		
		System.out.println("URL" + restUrl);
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String json = gson.toJson(input);
		
		System.out.println("Factura:"+json);
		
		
		
		String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(json), String.class);
		
		System.out.println("==>>"+responseJson);
		
		response = gson.fromJson(responseJson, FacturaRespuestaSRI.class);
		
		
		return response;
	}
	
	private NotaCreditoRespuesta creditNote(NotaCredito input){
		NotaCreditoRespuesta response = new NotaCreditoRespuesta();
		
		String restUrl = datilWebServiceUrl = "/credit-notes/issue/";
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
		
		
		
		Response responseRest =target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(input));
		
		
		response = (NotaCreditoRespuesta)responseRest.getEntity();
		
			
		return response;
	}
	
	
	public FacturaRespuestaSRI processInvoiceOrder(OrderComplete orderComplete){
		
		FacturaSRI factura = new FacturaSRI();
		
		//Preparar informacion de la factura
		factura.setSecuencial(tableSequenceService.getNextValue("SEQ_INVOICE").intValue());
		factura.setTipoEmision(1);
		factura.setAmbiente(1);
		factura.setMoneda(datilCurrencyCode);
		factura.setFechaEmision(UtilDate.formatDateISO(new Date()));
		//factura.setFechaEmision("2015-02-28T11:28:56.782Z");
		List<Item> items = new ArrayList<Item>();
		
		factura.setEmisor(loadEmisorInfo());
		factura.setComprador(loadComprador(orderComplete));
		
		for(ItemComplete ic:orderComplete.getItems()){
			Item it = new Item();
			it.setCantidad(ic.getQuantity().doubleValue());
			it.setPrecioTotalSinImpuestos(ic.getListPrice());
			it.setPrecioUnitario(ic.getSellingPrice());
			it.setDescripcion(ic.getName());
			it.setCodigoPrincipal(ic.getProductId());
			it.setDescuento(0D);
			//it.setImpuestos(impuestos);
			Impuesto_ iva = new Impuesto_();
			iva.setValor(ic.getPrice());
			iva.setCodigo(datilIvaCode);
			iva.setCodigoPorcentaje(datilIvaCodePercent);
			iva.setBaseImponible(ic.getListPrice());
			iva.setTarifa(new Double(datilIvaValue));
			
			List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
			impuestos.add(iva);
			
			it.setImpuestos(impuestos);
			
			items.add(it);
		}
		
		factura.setItems(items);
		
		
		
		
		Totales totales = new Totales();
		totales.setTotalSinImpuestos(orderComplete.getValue().doubleValue());
		totales.setDescuento(0D);
		totales.setPropina(0D);
		totales.setImporteTotal(orderComplete.getValue().doubleValue());
		//totales.set
		
		factura.setTotales(totales);
		
		FacturaRespuestaSRI response = invoice(factura);
		
		return response;
	}
	
	
	public FacturaRespuestaSRI getInvoice(String id){
		client = ClientBuilder.newClient();

		String restUrl = datilWebServiceUrl + "/invoices/"+id;
		target = client.target(restUrl);

		
		String json = target.request(MediaType.TEXT_PLAIN).headers(buildHeaders()).get(String.class);

		FacturaRespuestaSRI response = new Gson().fromJson(json, FacturaRespuestaSRI.class);
		
		return response;
	}
	
	public NotaCreditoRespuesta processCreditNote(CreditNoteBean creditNoteBean){
		NotaCredito notaCredito = new NotaCredito();
		
		notaCredito.setAmbiente(1);
		notaCredito.setEmisor(loadEmisorInfo());
		notaCredito.setComprador(loadComprador(creditNoteBean.getOrderComplete()));
		
		//notaCredito.set
	
		NotaCreditoRespuesta response = creditNote(notaCredito);
		
		return response;
	}
	
	private Emisor loadEmisorInfo(){
		Emisor emisor = new Emisor();
		Establecimiento establecimiento = new Establecimiento();
		establecimiento.setCodigo(datilEstablishmentCode);
		establecimiento.setDireccion(datilEstablishmentAddress);
		establecimiento.setPuntoEmision(datilEmissionCode);
		emisor.setEstablecimiento(establecimiento);
		emisor.setDireccion(datilEstablishmentAddress);
		emisor.setRuc(datilRucNumber);
		emisor.setRazonSocial(datilSocialReasson);
		emisor.setNombreComercial(datilSocialReasson);
		emisor.setObligadoContabilidad(Boolean.TRUE);
		emisor.setContribuyenteEspecial("");
		
		return emisor;
	}
	
	private Comprador loadComprador(OrderComplete orderComplete){
		Comprador comprador = new Comprador();
		comprador.setEmail(orderComplete.getClientProfileData().getEmail());
		comprador.setIdentificacion(orderComplete.getClientProfileData().getDocument());
		comprador.setRazonSocial(orderComplete.getCustomerName());
		comprador.setTipoIdentificacion(determineDocumentType(orderComplete.getClientProfileData().getDocument()));
		
		
		return comprador;
		
	}
	
	private String determineDocumentType(String document){
		String result  = "05"; //CEDULA
		if(document.length()==10){
			return result;
		}else if(document.length()==13){
			result  = "04"; //RUC
		}else{
			result  = "06"; //Pasaporte
		}
		
		return result;
	}
	
	
	
	
	private MultivaluedMap<String,Object> buildHeaders(){
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add("Content-Type", "application/json");
		myHeaders.add("X-Key", datilApiKey);
		myHeaders.add("X-Password", datilSriPassword);
		
		return myHeaders;
	}
}
