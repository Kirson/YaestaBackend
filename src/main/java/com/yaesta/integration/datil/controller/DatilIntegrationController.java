package com.yaesta.integration.datil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.service.DatilService;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.service.OrderVitexService;

@RestController
@RequestMapping(value = "/datilIntegration")
public class DatilIntegrationController {
	
	@Autowired
	OrderVitexService orderVitexService;
	
	@Autowired
	DatilService datilService;

	@RequestMapping(value = "/testFactura/", method = RequestMethod.POST)
	public FacturaRespuestaSRI testFactura(){
		
		OrderComplete oc = orderVitexService.getOrderComplete("648410909096-01");
		
		return datilService.processInvoiceOrder(oc);
	}
	
	/*
	public FacturaRespuestaSRI getInvoice(){
		
	}
	*/
}
