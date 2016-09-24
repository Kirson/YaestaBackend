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



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.app.persistence.service.TableSequenceService;
import com.yaesta.app.persistence.service.YaEstaLogService;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.base.util.BaseUtil;
import com.yaesta.integration.datil.json.bean.Comprador;
import com.yaesta.integration.datil.json.bean.Destinatario;
import com.yaesta.integration.datil.json.bean.DetallesAdicionales;
import com.yaesta.integration.datil.json.bean.Emisor;
import com.yaesta.integration.datil.json.bean.Establecimiento;
import com.yaesta.integration.datil.json.bean.FacturaConsulta;
import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.json.bean.FacturaSRI;
import com.yaesta.integration.datil.json.bean.GuiaRemision;
import com.yaesta.integration.datil.json.bean.GuiaRemisionRespuesta;
import com.yaesta.integration.datil.json.bean.Impuesto;
import com.yaesta.integration.datil.json.bean.Impuesto_;
import com.yaesta.integration.datil.json.bean.InformacionAdicional;
import com.yaesta.integration.datil.json.bean.Item;
import com.yaesta.integration.datil.json.bean.ItemGuiaRemision;
import com.yaesta.integration.datil.json.bean.NotaCredito;
import com.yaesta.integration.datil.json.bean.NotaCreditoRespuesta;
import com.yaesta.integration.datil.json.bean.Pago;
import com.yaesta.integration.datil.json.bean.ResponseError;
import com.yaesta.integration.datil.json.bean.Totales;
import com.yaesta.integration.datil.json.bean.Transportista;
import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.datil.json.enums.TipoDocumentoEnum;
import com.yaesta.integration.vitex.bean.CreditNoteBean;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;
import com.yaesta.integration.vitex.bean.WayBillSchema;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;

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
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	GuideService guideService;
	
	@Autowired
	YaEstaLogService logService;

	private @Value("${mail.smtp.to}") String mailSmtpTo;
	private @Value("${datil.api.key}") String datilApiKey;
	private @Value("${datil.webservice.url}") String datilWebServiceUrl;
	private @Value("${datil.webhook.url}") String datilWebhookUrl;
	private @Value("${datil.documents.url}") String datilDocumentsUrl;
	private @Value("${datil.sri.password}") String datilSriPassword;
	private @Value("${datil.enviroment.type}") String datilEnviromentType;
	private @Value("${datil.emission.type}") String datilEmissionType;
	private @Value("${datil.emission.waybill.type}") String datilEmissionWayBillType;
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
	private @Value("${datil.carrier.motoexpress.name}") String datilCarrierMotoExpressName;
	private @Value("${datil.carrier.motoexpress.document}") String datilCarrierMotoExpressDocument;
	private @Value("${datil.carrier.motoexpress.contact}") String datilCarrierMotoExpressContact;
	private @Value("${datil.carrier.motoexpress.phone}") String datilCarrierMotoExpressPhone;
	private @Value("${datil.carrier.motoexpress.email}") String datilCarrierMotoExpressEmail;
	private @Value("${datil.carrier.motoexpress.address}") String datilCarrierMotoExpressAddress;
	private @Value("${datil.carrier.motoexpress.license.plate}") String datilCarrierMotoExpressLicensePlate;
	private @Value("${datil.carrier.motoexpress.motive}") String datilCarrierMotoExpressMotive;
	private @Value("${datil.carrier.motoexpress.route}") String datilCarrierMotoExpressRoute;
	private @Value("${datil.carrier.internal.name}") String datilCarrierInternalName;
	private @Value("${datil.carrier.internal.document}") String datilCarrierInternalDocument;
	private @Value("${datil.carrier.internal.contact}") String datilCarrierInternalContact;
	private @Value("${datil.carrier.internal.phone}") String datilCarrierInternalPhone;
	private @Value("${datil.carrier.internal.email}") String datilCarrierInternalEmail;
	private @Value("${datil.carrier.internal.address}") String datilCarrierInternalAddress;
	private @Value("${datil.carrier.internal.license.plate}") String datilCarrierInternalLicensePlate;
	private @Value("${datil.carrier.internal.motive}") String datilCarrierInternalMotive;
	private @Value("${datil.carrier.internal.route}") String datilCarrierInternalRoute;
	private @Value("${datil.carrier.motive}") String datilCarrierMotive;
	private @Value("${datil.carrier.route}") String datilCarrierRoute;

	
	private Client client;
	private WebTarget target;

	private FacturaRespuestaSRI invoice(FacturaSRI input, OrderComplete orderComplete){
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
		
		YaEstaLog yaestaLog = new YaEstaLog();
		yaestaLog.setLogDate(new Date());
		yaestaLog.setXmlInfo(responseJson);
		yaestaLog.setProcessName("INVOICE");
		yaestaLog.setTextinfo(orderComplete.getOrderId());
		logService.save(yaestaLog);
		
		response = gson.fromJson(responseJson, FacturaRespuestaSRI.class);
		return response;
	}
	
	private GuiaRemisionRespuesta waybill(GuiaRemision input){
		GuiaRemisionRespuesta response = new GuiaRemisionRespuesta();
		
		String restUrl = datilWebServiceUrl + "/waybills/issue";
		
		System.out.println("URL" + restUrl);
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String json = gson.toJson(input);
		
		System.out.println("Guia de Remision:"+json);
		String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(json), String.class);
		System.out.println("==>>"+responseJson);
		
		response = gson.fromJson(responseJson, GuiaRemisionRespuesta.class);
		return response;
	}
	
	private NotaCreditoRespuesta creditNote(NotaCredito input, OrderComplete orderComplete){
		NotaCreditoRespuesta response = new NotaCreditoRespuesta();
		
		String restUrl = datilWebServiceUrl + "/credit-notes/issue";
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String json = gson.toJson(input);
		
		System.out.println("Nota de Credito:"+json);
		try{
			
			String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(json), String.class);
		
			System.out.println("1==>>"+responseJson);
			
			YaEstaLog yaestaLog = new YaEstaLog();
			yaestaLog.setLogDate(new Date());
			yaestaLog.setXmlInfo(responseJson);
			yaestaLog.setProcessName("INVOICE");
			yaestaLog.setTextinfo(orderComplete.getOrderId());
			logService.save(yaestaLog);
		
			response = gson.fromJson(responseJson, NotaCreditoRespuesta.class);
		}catch(Exception e){
			System.out.println("2==>>"+e.getMessage());
			String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(json), String.class);
			ResponseError responseError = gson.fromJson(responseJson, ResponseError.class);
			response.setErrors(responseError.getErrors());
		}
			
		return response;
	}
	
	
	@SuppressWarnings("unused")
	public FacturaRespuestaSRI processInvoiceOrder(OrderComplete orderComplete){
		
		FacturaSRI factura = new FacturaSRI();
		
		//Preparar informacion de la factura
		factura.setSecuencial(tableSequenceService.getNextValue("SEQ_INVOICE").intValue());
		factura.setTipoEmision(new Integer(datilEmissionType).intValue());
		factura.setAmbiente(new Integer(datilEnviromentType).intValue());
		factura.setMoneda(datilCurrencyCode);
		factura.setFechaEmision(UtilDate.formatDateISO(new Date()));
		List<Item> items = new ArrayList<Item>();
		
		factura.setEmisor(loadEmisorInfo());
		factura.setComprador(loadComprador(orderComplete));
		
		Double subTotalShipping = new Double(0);
		Double subTotalIVAShipping = new Double(0);
		Double addDiscount = 0D;
		
		for(ItemComplete ic:orderComplete.getItems()){
			Item it = new Item();
			Double quantity = 1D;
			
			if(ic.getQuantity()!=null){
				quantity = ic.getQuantity().doubleValue();
			}
			it.setCantidad(quantity);
			Double discount = 0D;
			Double unitPrice = 0D;
			Double taxValue = 0D;
			unitPrice = ic.getPrice();
			
			Double itemPrice = ic.getPrice() * quantity;
			itemPrice = (double) Math.round(itemPrice * 100) / 100;
			
			it.setDescripcion(ic.getName());
			//it.setCodigoPrincipal(ic.getProductId());
			String refId = (String)ic.getRefId();
			String productCode[] = SupplierUtil.returnSupplierCode(refId);
			String principalCode = productCode[0]; 
			if(principalCode.length()>25){
				principalCode = principalCode.substring(0,24);
			}
			it.setCodigoPrincipal(principalCode);
			Boolean hasTax = Boolean.FALSE;
			
			if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
				for(PriceTag pt:ic.getPriceTags()){
					if(pt.getName().contains("discount@price")){
						Double val= pt.getValue();
						if(val<0){
							val = val* (-1);
						}
					    val = (double) Math.round(val * 100) / 100;
					    discount = discount + Math.abs(val);
					    discount = (double) Math.round(discount * 100) / 100;
					    it.setDescuento(discount);
						//break;
					}
					if(pt.getName().contains("DISCOUNT@MARKETPLACE"))
					{
						Double val= pt.getValue();
						if(val<0){
							val = val* (-1);
						}
					    val = (double) Math.round(val * 100) / 100;
					    addDiscount=addDiscount+Math.abs(val);
					    discount = discount+addDiscount;
					    discount = (double) Math.round(discount * 100) / 100;
					    
					    it.setDescuento(discount);
					    
					}
					if(pt.getName().contains("tax@price")){
						hasTax=Boolean.TRUE;
						taxValue = pt.getValue();
					}
				}
			}else{
				it.setDescuento(discount);
			}
			
			it.setDescuento(discount);
			//unitPrice = unitPrice - discount;
			unitPrice = (double) Math.round(unitPrice * 100) / 100;
			it.setPrecioUnitario(unitPrice);
			Double precioTotalSinImpuestos = itemPrice -discount;
			precioTotalSinImpuestos = (double) Math.round(precioTotalSinImpuestos * 100) / 100;
			it.setPrecioTotalSinImpuestos(precioTotalSinImpuestos);
			
			Impuesto_ iva = new Impuesto_();
			if(ic.getTax()>0){
				iva.setValor(ic.getTax());
			}else{
				if(hasTax){
					iva.setValor(BaseUtil.calculateIVA(precioTotalSinImpuestos,new Integer(datilIvaValue),datilIvaPercentValue));
				}
			}
			iva.setCodigo(datilIvaCode);
			iva.setCodigoPorcentaje(datilIvaCodePercent);
			iva.setBaseImponible(precioTotalSinImpuestos);
			iva.setTarifa(new Double(datilIvaValue));
			
			List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
			impuestos.add(iva);
			
			it.setImpuestos(impuestos);
			
			
			items.add(it);
		}//fin del for de items
		
		Double subTotal = new Double(0);
		
		for(Total vtot: orderComplete.getTotals())
		{
			
			if(vtot.getId().equals("Items")){
				subTotal = subTotal+vtot.getValue();
			}
			if(vtot.getId().equals("Shipping")){
				subTotalShipping = subTotalShipping + vtot.getValue();
				if(vtot.getValue()>0){
				Item it = new Item();
				it.setCantidad(1D);
				it.setPrecioTotalSinImpuestos(vtot.getValue());
				it.setPrecioUnitario(vtot.getValue());
				it.setDescripcion(vtot.getSpanishName());
				it.setCodigoPrincipal(datilTransportCode);
				it.setDescuento(0D);
				
				Impuesto_ iva = new Impuesto_();
				iva.setValor(BaseUtil.calculateIVA(vtot.getValue(),new Integer(datilIvaValue),datilIvaPercentValue));
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
			if(vtot.getId().equals("Discounts")){
				subTotal = subTotal-Math.abs(vtot.getValue());
			}
		}
		
		
		
		Totales totales = new Totales();
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
				totales.setDescuento(Math.abs(val));
				//totales.setDescuentoAdicional(Math.abs(val));
				totales.setDescuentoAdicional(0D);
				
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
		
		
		if(addDiscount.intValue()>0){
		  totales.setDescuentoAdicional(addDiscount);
		}
		
		totales.setImpuestos(impList);	
		
		
		
		totales.setPropina(0D);
		
		
		totales.setImporteTotal(orderComplete.getValue().doubleValue());
		
		factura.setTotales(totales);
		
		factura.setItems(items);
		List<Pago> pagos = new ArrayList<Pago>();
		if(orderComplete.getPaymentData().getTransactions()!=null && !orderComplete.getPaymentData().getTransactions().isEmpty()){
			for(Transaction tr:orderComplete.getPaymentData().getTransactions()){
				if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
					for(Payment py:tr.getPayments()){
						Pago pago = new Pago();
						pago.setTotal(py.getValue());
						
						System.out.println("SystemPaymentname "+py.getPaymentSystemName());
						if(py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())){
							pago.setMedio(PagoEnum.EFECTIVO.getCodigoDatil());
						}else if(py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TRANSFER_OTRO_BANCO.getCodigoDatil());
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TRANSFER_OTRO_BANCO.getCodigoDatil());
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.CONSIGNACION_BANCARIA.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TRANSFER_OTRO_BANCO.getCodigoDatil());
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.TRANSFERENCIA_BANCARIA.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TRANSFER_OTRO_BANCO.getCodigoDatil());
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TARJETA_CREDITO_NACIONAL.getCodigoDatil());
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TARJETA_CREDITO_NACIONAL.getCodigoDatil());
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TARJETA_CREDITO_NACIONAL.getCodigoDatil());
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())){
							pago.setMedio(PagoEnum.TARJETA_CREDITO_INTERNACIONAL.getCodigoDatil());
						}
						
						System.out.println("Medio " +pago.getMedio());
						pagos.add(pago);
					}//fin for
					
					factura.setPagos(pagos);
				}//
			}
		}
		
		FacturaRespuestaSRI response = invoice(factura, orderComplete);
		
		Order order = orderService.findByVitexId(orderComplete.getOrderId());
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String toJson = gson.toJson(response);
		order.setInvoice(toJson);
		
		orderService.saveOrder(order);
		
		return response;
	}
	
	public FacturaConsulta findInvoice(String id){
		client = ClientBuilder.newClient();	
		String restUrl = datilWebServiceUrl + "/invoices/"+id;
		target = client.target(restUrl);

		
		String json = target.request(MediaType.TEXT_PLAIN).headers(buildHeaders()).get(String.class);

		FacturaConsulta response = new Gson().fromJson(json, FacturaConsulta.class);
		
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
		
		Order order = orderService.findByVitexId(creditNoteBean.getOrderComplete().getOrderId());
		
		System.out.println("Obtiene orden "+order.getId());
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		
		FacturaRespuestaSRI fr = gson.fromJson(order.getInvoice(), FacturaRespuestaSRI.class);
	
		System.out.println("Obtiene factura "+fr.getId());
		
		creditNoteBean.setInvoiceNumber(formatInvoiceNumber(fr.getSecuencial()+""));
		creditNoteBean.setInvoiceDate(fr.getFechaEmision());
		
		NotaCredito notaCredito = new NotaCredito();
		
		notaCredito.setAmbiente(new Integer(datilEnviromentType).intValue());
		notaCredito.setSecuencial(tableSequenceService.getNextValue("SEQ_CREDIT_NOTE").intValue());
		notaCredito.setTipoEmision(new Integer(datilEmissionType).intValue());
		notaCredito.setMoneda(datilCurrencyCode);
		notaCredito.setMotivo(creditNoteBean.getMotive());
		
		
		notaCredito.setEmisor(loadEmisorInfo());
		notaCredito.setComprador(loadComprador(creditNoteBean.getOrderComplete()));
		notaCredito.setFechaEmision(UtilDate.formatDateISO(new Date()));
		notaCredito.setFechaEmisionDocumentoModificado(creditNoteBean.getInvoiceDate());
		notaCredito.setNumeroDocumentoModificado(formatInvoiceNumber(fr.getSecuencial()+""));
		notaCredito.setTipoDocumentoModificado(TipoDocumentoEnum.FACTURA.getCode());
		
		List<Item> items = new ArrayList<Item>();
		Double subTotalShipping = new Double(0);
		Double subTotalIVAShipping = new Double(0);
		
		for(ItemComplete ic:creditNoteBean.getOrderComplete().getItems()){
			Item it = new Item();
			
			Double quantity = 1D;
			
			if(ic.getQuantity()!=null){
				quantity = ic.getQuantity().doubleValue();
			}
			it.setCantidad(quantity);
			Double unitPrice = 0D;
			Double discount = 0D;
			
			Double itemPrice = ic.getPrice() * quantity;
			itemPrice = (double) Math.round(itemPrice * 100) / 100;
			unitPrice = ic.getPrice();
			it.setPrecioTotalSinImpuestos(itemPrice);
			it.setDescripcion(ic.getName());
			//it.setCodigoPrincipal(ic.getProductId());
			String refId = (String)ic.getRefId();
			String productCode[] = SupplierUtil.returnSupplierCode(refId);
			String principalCode = productCode[0]; 
			if(principalCode.length()>25){
				principalCode = principalCode.substring(0,24);
			}
			it.setCodigoPrincipal(principalCode);
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
					    it.setDescuento(discount);
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
					    it.setDescuento(discount);
					}
					if(pt.getName().contains("tax@price")){
						hasTax=Boolean.TRUE;
						//vTax = pt.getValue();
					}
				}
			}else{
				it.setDescuento(discount);
			}
			
			//unitPrice = unitPrice -discount;
			unitPrice = (double) Math.round(unitPrice * 100) / 100;
			it.setDescuento(discount);
			
			it.setPrecioUnitario(unitPrice);
			Double precioTotalSinImpuestos = itemPrice -discount;
			precioTotalSinImpuestos = (double) Math.round(precioTotalSinImpuestos * 100) / 100;
			it.setPrecioTotalSinImpuestos(precioTotalSinImpuestos);

			
			
			Impuesto_ iva = new Impuesto_();
			if(ic.getTax()>0){
				iva.setValor(ic.getTax());
			}else{
				if(hasTax){
					iva.setValor(BaseUtil.calculateIVA(precioTotalSinImpuestos,new Integer(datilIvaValue),datilIvaPercentValue));
				}
			}
			iva.setCodigo(datilIvaCode);
			iva.setCodigoPorcentaje(datilIvaCodePercent);
			iva.setBaseImponible(precioTotalSinImpuestos);
			iva.setTarifa(new Double(datilIvaValue));
			
			List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
			impuestos.add(iva);
			
			it.setImpuestos(impuestos);
			
			items.add(it);
		}
		
		Double subTotal = new Double(0);
		
		for(Total vtot: creditNoteBean.getOrderComplete().getTotals())
		{
			
			if(vtot.getId().equals("Items")){
				subTotal = subTotal+vtot.getValue();
			}
			if(vtot.getId().equals("Shipping")){
				subTotalShipping = subTotalShipping + vtot.getValue();
				if(vtot.getValue()>0){
					Item it = new Item();
					it.setCantidad(1D);
					it.setPrecioTotalSinImpuestos(vtot.getValue());
					it.setPrecioUnitario(vtot.getValue());
					it.setDescripcion(vtot.getSpanishName());
					it.setCodigoPrincipal(datilTransportCode);
					it.setDescuento(0D);
				
					Impuesto_ iva = new Impuesto_();
					iva.setValor(BaseUtil.calculateIVA(vtot.getValue(),new Integer(datilIvaValue),datilIvaPercentValue));
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
		List<Impuesto> impList = new ArrayList<Impuesto>();
		for(Total tot: creditNoteBean.getOrderComplete().getTotals())
		{
			
			if(tot.getId().equals("Items")){
				Double val=(double) Math.round((subTotal+subTotalShipping) * 100) / 100;
				totales.setTotalSinImpuestos(val);
			}else if(tot.getId().equals("Discounts")){
				Double val = tot.getValue();
				if(val<0){
					val = val * (-1);
				}
				//totales.setDescuento(val);
				//totales.setDescuentoAdicional(val);
				
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
		
		
		
		//totales.setPropina(0D);
		
		
		totales.setImporteTotal(creditNoteBean.getOrderComplete().getValue().doubleValue());
		
		notaCredito.setTotales(totales);
		
		notaCredito.setItems(items);
		
		
	
		NotaCreditoRespuesta response = creditNote(notaCredito,creditNoteBean.getOrderComplete());
		
		
		String toJson = gson.toJson(response);
		order.setCreditNote(toJson);
		
		orderService.saveOrder(order);
		
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
	
	private Transportista loadCarrier(Catalog delivery){
		if(delivery.getNemonic().equals("MOTO_EXPRESS")){
			return loadCarrierMotoExpress();
		}else if(delivery.getNemonic().equals("DESPACHO_INTERNO")){
			return loadCarrierInternal();
		}else{
			return new Transportista();
		}
	}
	
	private Transportista loadCarrierMotoExpress(){
		Transportista carrier = new Transportista();
		carrier.setTipoIdentificacion(determineDocumentType(datilCarrierMotoExpressDocument));
		carrier.setRazonSocial(datilCarrierMotoExpressName + " " + datilCarrierMotoExpressContact);
		carrier.setEmail(datilCarrierMotoExpressEmail);
		carrier.setDireccion(datilCarrierMotoExpressAddress);
		carrier.setIdentificacion(datilCarrierMotoExpressDocument);
		carrier.setPlaca(datilCarrierMotoExpressLicensePlate);
		carrier.setTelefono(datilCarrierMotoExpressPhone);
		
		return carrier;
	}
	
	private Transportista loadCarrierInternal(){
		Transportista carrier = new Transportista();
		carrier.setTipoIdentificacion(determineDocumentType(datilCarrierInternalDocument));
		carrier.setRazonSocial(datilCarrierInternalName + " " + datilCarrierInternalContact);
		carrier.setEmail(datilCarrierInternalEmail);
		carrier.setDireccion(datilCarrierInternalAddress);
		carrier.setIdentificacion(datilCarrierInternalDocument);
		carrier.setPlaca(datilCarrierInternalLicensePlate);
		carrier.setTelefono(datilCarrierInternalPhone);
		
		return carrier;
	}
	
	private Comprador loadComprador(OrderComplete orderComplete){
		Comprador comprador = new Comprador();
		comprador.setEmail(orderComplete.getClientProfileData().getEmail());
		comprador.setIdentificacion(orderComplete.getClientProfileData().getDocument());
		comprador.setRazonSocial(orderComplete.getCustomerName());
		comprador.setTipoIdentificacion(determineDocumentType(orderComplete.getClientProfileData().getDocument()));
		
		String direccion = "";
		if(orderComplete.getShippingData()!=null){
			direccion = direccion+ orderComplete.getShippingData().getAddress().getCountry();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getState();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getCity();
			direccion = direccion+ " : " + orderComplete.getShippingData().getAddress().getStreet();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getNumber();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getComplement();
		}
		
		if(direccion.length()>250){
			direccion = direccion.substring(0, 250);
		}
		
		comprador.setDireccion(direccion);
		
		return comprador;
		
	}
	
	
	private Destinatario loadAddressee(OrderComplete orderComplete){
		
		Destinatario addressee = new Destinatario();
		addressee.setDocumentoAduaneroUnico("");
		String [] authNumber = orderComplete.getOrderId().split("-");
		addressee.setNumeroAutorizacionDocumentoSustento(authNumber[0]);
		addressee.setIdentificacion(orderComplete.getClientProfileData().getDocument());
		addressee.setEmail(orderComplete.getClientProfileData().getEmail());
		addressee.setRazonSocial(orderComplete.getCustomerName());
		addressee.setTipoIdentificacion(determineDocumentType(orderComplete.getClientProfileData().getDocument()));
		addressee.setTelefono(orderComplete.getClientProfileData().getPhone());
		String direccion = "";
		if(orderComplete.getShippingData()!=null){
			direccion = direccion+ orderComplete.getShippingData().getAddress().getCountry();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getState();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getCity();
			direccion = direccion+ " : " + orderComplete.getShippingData().getAddress().getStreet();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getNumber();
			direccion = direccion+ " - " + orderComplete.getShippingData().getAddress().getComplement();
		}
		addressee.setDireccion(direccion);
		addressee.setCodigoEstablecimientoDestino(datilEstablishmentCode);
		addressee.setMotivoTraslado(datilCarrierMotive);
		addressee.setRuta(datilCarrierRoute);
		
		
		return addressee;
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
	
	
	
	private String formatInvoiceNumber(String sequence){
		String sequencePart = ""+sequence;
		
		while(sequencePart.length()<9){
			sequencePart = "0"+sequencePart;
		}
		
		String invoiceNumber = datilEstablishmentCode + "-" + datilEmissionCode+ "-" + sequencePart;
		return invoiceNumber;
	}
	
	
public WayBillSchema processWayBill(OrderComplete orderComplete, Catalog delivery, String sequenceName){
		
	WayBillSchema response = new WayBillSchema();
	
	for(SupplierDeliveryInfo sdi:orderComplete.getSupplierDeliveryInfoList()){
	
		GuiaRemision guiaRemision = new GuiaRemision();
		InformacionAdicional informacionAdicional = new InformacionAdicional();
		
		//Preparar informacion de la Guia de Remision
		guiaRemision.setSecuencial(tableSequenceService.getNextValue(sequenceName).intValue());
		guiaRemision.setTipoEmision(new Integer(datilEmissionType).intValue());
		guiaRemision.setAmbiente(new Integer(datilEnviromentType).intValue());
		guiaRemision.setFechaInicioTransporte(UtilDate.formatDateISO(new Date()));
		guiaRemision.setFechaFinTransporte(UtilDate.formatDateISO(new Date()));
		guiaRemision.setEmisor(loadEmisorInfo());
		guiaRemision.setTransportista(loadCarrier(delivery));
		String strDirPar = "[Pro:_"+sdi.getSupplier().getId()+"_"+sdi.getSupplier().getName()+"] [Dir: " +sdi.getSupplier().getAddress()+ "] [Tel:"+sdi.getSupplier().getPhone() + "] [email:"+sdi.getSupplier().getContactEmail()+"]";
		if(strDirPar.length()>200){
			strDirPar = strDirPar.substring(0, 199);
		}
		guiaRemision.setDireccionPartida(strDirPar);
		
		List<Destinatario> destinatarios = new ArrayList<Destinatario>();
		Destinatario destinatario = loadAddressee(orderComplete);
		informacionAdicional.setValorACobrar("0");
		
		if(orderComplete.getPaymentData().getTransactions()!=null && !orderComplete.getPaymentData().getTransactions().isEmpty()){
			for(Transaction tr:orderComplete.getPaymentData().getTransactions()){
				if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
					for(Payment py:tr.getPayments()){
						informacionAdicional.setFormaPago(py.getPaymentSystemName());
						System.out.println("SystemPaymentname "+py.getPaymentSystemName());
						if(py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())){
							informacionAdicional.setValorACobrar(orderComplete.getValue().doubleValue()+"");
						}
						
					}//fin for
				}//
			}//fin for de transaction
		}
		
		informacionAdicional.setNombreProveedor(sdi.getSupplier().getName());
		
		List<ItemGuiaRemision> items = new ArrayList<ItemGuiaRemision>();
		
		String auxMotive = "[Forma de Pago: " + informacionAdicional.getFormaPago() + "] [Valor a Cobrar: "+informacionAdicional.getValorACobrar()+"]"; 
		
		destinatario.setMotivoTraslado(datilCarrierMotive + ": " + auxMotive);
		
		for(ItemComplete ic:sdi.getItems()){
			ItemGuiaRemision item = new ItemGuiaRemision();
			item.setCantidad(new Double(ic.getQuantity()));
			item.setCodigoPrincipal(ic.getId());
			item.setCodigoAuxiliar(ic.getEan());
			item.setDescripcion(ic.getName());
			DetallesAdicionales da = new DetallesAdicionales();
			da.setNumero(ic.getId());
			da.setSerie(ic.getProductId());
			item.setDetallesAdicionales(da);
			items.add(item);
		}
		
		
		
		guiaRemision.setInformacionAdicional(informacionAdicional);
		destinatario.setItems(items);
		destinatarios.add(destinatario);
		guiaRemision.setDestinatarios(destinatarios);
		
		GuiaRemisionRespuesta grr = waybill(guiaRemision);
		
		Order order = orderService.findByVitexId(orderComplete.getOrderId());
		
		Guide guide = new Guide();
		guide.setOrder(order);
		
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String toJson = gson.toJson(grr);
		guide.setGuideInfo(toJson);
		
		guideService.saveGuide(guide);
		
		response.getGuideList().add(grr);
	}
		return response;
	}
	
	
}
