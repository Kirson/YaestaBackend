package com.yaesta.integration.datil.service;


import java.io.Serializable;
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
import com.yaesta.integration.datil.json.bean.Impuesto;
import com.yaesta.integration.datil.json.bean.Impuesto_;
import com.yaesta.integration.datil.json.bean.Item;
import com.yaesta.integration.datil.json.bean.NotaCredito;
import com.yaesta.integration.datil.json.bean.NotaCreditoRespuesta;
import com.yaesta.integration.datil.json.bean.Totales;
import com.yaesta.integration.vitex.bean.CreditNoteBean;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;

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
	private @Value("${datil.iva.percent.value}") String datilIvaPercentValue;
	private @Value("${datil.iva.code}") String datilIvaCode;
	private @Value("${datil.iva.code.percent}") String datilIvaCodePercent;
	private @Value("${datil.transport.code}") String datilTransportCode;

	
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
		factura.setTipoEmision(new Integer(datilEmissionType).intValue());
		factura.setAmbiente(new Integer(datilEnviromentType).intValue());
		factura.setMoneda(datilCurrencyCode);
		factura.setFechaEmision(UtilDate.formatDateISO(new Date()));
		//factura.setFechaEmision("2015-02-28T11:28:56.782Z");
		List<Item> items = new ArrayList<Item>();
		
		factura.setEmisor(loadEmisorInfo());
		factura.setComprador(loadComprador(orderComplete));
		
		Double subTotalShipping = new Double(0);
		Double subTotalIVAShipping = new Double(0);
		
		for(ItemComplete ic:orderComplete.getItems()){
			Item it = new Item();
			it.setCantidad(ic.getQuantity().doubleValue());
			it.setPrecioTotalSinImpuestos(ic.getListPrice());
			//it.setPrecioUnitario(ic.getSellingPrice());
			it.setPrecioUnitario(ic.getListPrice());
			it.setDescripcion(ic.getName());
			it.setCodigoPrincipal(ic.getProductId());
			
			if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
				for(PriceTag pt:ic.getPriceTags()){
					if(pt.getName().contains("discount@price")){
						Double val= pt.getValue();
						if(val.intValue()<0){
							val = val* (-1);
						}
					    val = (double) Math.round(val * 100) / 100;
						it.setDescuento(val);
						break;
					}
				}
			}else{
				it.setDescuento(0D);
			}
			
			it.setDescuento(0D);
			//it.setImpuestos(impuestos);
			Impuesto_ iva = new Impuesto_();
			if(ic.getTax().intValue()==0){
				iva.setValor(calculateIVA(ic.getListPrice(),new Integer(datilIvaValue)));
			}else{
				iva.setValor(ic.getTax());
			}
			iva.setCodigo(datilIvaCode);
			iva.setCodigoPorcentaje(datilIvaCodePercent);
			iva.setBaseImponible(ic.getListPrice());
			iva.setTarifa(new Double(datilIvaValue));
			
			List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
			impuestos.add(iva);
			
			it.setImpuestos(impuestos);
			
			items.add(it);
		}
		
		Double subTotal = new Double(0);
		
		for(Total vtot: orderComplete.getTotals())
		{
			
			if(vtot.getId().equals("Items")){
				subTotal = subTotal+vtot.getValue();
			}
			if(vtot.getId().equals("Shipping")){
				subTotalShipping = subTotalShipping + vtot.getValue();
				if(vtot.getValue().intValue()>0){
				Item it = new Item();
				it.setCantidad(1D);
				it.setPrecioTotalSinImpuestos(vtot.getValue());
				it.setPrecioUnitario(vtot.getValue());
				it.setDescripcion(vtot.getSpanishName());
				it.setCodigoPrincipal(datilTransportCode);
				it.setDescuento(0D);
				
				Impuesto_ iva = new Impuesto_();
				iva.setValor(calculateIVA(vtot.getValue(),new Integer(datilIvaValue)));
				iva.setCodigo(datilIvaCode);
				iva.setCodigoPorcentaje(datilIvaCodePercent);
				iva.setBaseImponible(vtot.getValue());
				iva.setTarifa(new Double(datilIvaValue));
				subTotalIVAShipping=subTotalIVAShipping+iva.getValor();
				List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
				impuestos.add(iva);
				
				it.setImpuestos(impuestos);
				items.add(it);
				}
			}
		}
		
		
		
		Totales totales = new Totales();
		//Double taxes = subTotalIVAShipping;
		List<Impuesto> impList = new ArrayList<Impuesto>();
		for(Total tot: orderComplete.getTotals())
		{
			
			if(tot.getId().equals("Items")){
				Double val=(double) Math.round((subTotal+subTotalShipping) * 100) / 100;
				totales.setTotalSinImpuestos(val);
			}else if(tot.getId().equals("Discounts")){
				Double val = tot.getValue();
				if(val<0){
					val = val * (-1);
				}
				totales.setDescuento(val);
				totales.setDescuentoAdicional(val);
				
			}else if(tot.getId().equals("Shipping")){
			  //NOTHING TODO
			}else if(tot.getId().equals("Tax")){
				//taxes = taxes + tot.getValue();
				Impuesto imp =new Impuesto();
				Double val=(double) Math.round(tot.getValue() * 100) / 100;
				imp.setValor(val);
				imp.setCodigo(datilIvaCode);
				imp.setCodigoPorcentaje(datilIvaCodePercent);
				imp.setBaseImponible(totales.getTotalSinImpuestos());
				impList.add(imp);
				
			}
		}
		totales.setImpuestos(impList);	
		
		
		
		totales.setPropina(0D);
		
		
		totales.setImporteTotal(orderComplete.getValue().doubleValue());
		//totales.set
		
		
		factura.setTotales(totales);
		
		factura.setItems(items);
		
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
	
	private Double calculateIVA(Double price, int percent){
		//System.out.println("Precio "+price);
		//System.out.println("Porcentaje "+percent);
		Double vpercent = new Double(datilIvaPercentValue);
		//System.out.println("VPorcentaje "+vpercent);
		
		Double iva = price*vpercent;
		//System.out.println("iva "+vpercent);
		
		iva = (double) Math.round(iva * 100) / 100;
		
		return iva;
	}
	
	
}
