package com.yaesta.integration.datil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.integration.datil.json.bean.FacturaConsulta;
import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.json.bean.NotaCreditoRespuesta;
import com.yaesta.integration.datil.service.DatilService;
import com.yaesta.integration.vitex.bean.CreditNoteBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.service.OrderVitexService;

@RestController
@RequestMapping(value = "/datilIntegration")
public class DatilIntegrationController {
	
	@Autowired
	OrderVitexService orderVitexService;
	
	@Autowired
	DatilService datilService;
	
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/testFactura/", method = RequestMethod.POST)
	public FacturaRespuestaSRI testFactura(){
		
		OrderComplete oc = orderVitexService.getOrderComplete("648410909096-01");
		
		return datilService.processInvoiceOrder(oc);
	}
	
	@RequestMapping(value = "/testFacturaMapper/", method = RequestMethod.GET)
	public FacturaConsulta testFacturaMapper(){
		
		String orderId = "650141505758-01";
		
		Order order = orderService.findByVitexId(orderId);
		
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		
		FacturaRespuestaSRI fr = gson.fromJson(order.getInvoice(), FacturaRespuestaSRI.class);
	
		FacturaConsulta fc = datilService.findInvoice(fr.getId());
		
		
		
		return fc;
	}
	
	
	@RequestMapping(value = "/testNotaCredito/", method = RequestMethod.GET)
	public NotaCreditoRespuesta testNotaCredito(){
		
		String orderId = "650141505758-01";
		//Order order = orderService.findByVitexId(orderId);
		
		OrderComplete oc = orderVitexService.getOrderComplete(orderId);
		
		CreditNoteBean cnb = new CreditNoteBean();
		cnb.setOrderComplete(oc);
		cnb.setMotive("Obsequio cliente");
		
		NotaCreditoRespuesta ncr =datilService.processCreditNote(cnb);
		
		return ncr;
	}
	
}
