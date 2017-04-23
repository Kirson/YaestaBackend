package com.yaesta.integration.datil.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.service.CatalogService;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.integration.datil.json.bean.FacturaConsulta;
import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.json.bean.NotaCreditoRespuesta;
import com.yaesta.integration.datil.service.DatilService;
import com.yaesta.integration.vitex.bean.CreditNoteBean;
import com.yaesta.integration.vitex.bean.WayBillSchema;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.service.OrderVitexService;

@Controller
@Api(name = "DATIL API", 
     description = "Methods for managing DATIL INTEGRATION", 
     group = "Integration",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
@RestController
@RequestMapping(value = "/datilIntegration")
public class DatilIntegrationController {
	
	@Autowired
	OrderVitexService orderVitexService;
	
	@Autowired
	DatilService datilService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CatalogService catalogService;

	@Deprecated
	@RequestMapping(value = "/testFactura/", method = RequestMethod.POST)
	public FacturaRespuestaSRI testFactura(){
		
		OrderComplete oc = orderVitexService.getOrderComplete("648410909096-01");
		
		return datilService.processInvoiceOrder(oc);
	}
	
	@Deprecated
	@RequestMapping(value = "/testFacturaMapper/", method = RequestMethod.GET)
	public FacturaConsulta testFacturaMapper(){
		
		//String orderId = "650141505758-01";
		
		//Order order = orderService.findByVitexId(orderId);
		
		
		//Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		
		//FacturaRespuestaSRI fr = gson.fromJson(order.getInvoice(), FacturaRespuestaSRI.class);
	
		//FacturaConsulta fc = datilService.findInvoice(fr.getId());
		
		FacturaConsulta fc = datilService.findInvoice("2010201601260117924781030010000026019");
		
		
		
		
		return fc;
	}
	
	@Deprecated
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
	
	@Deprecated
	@RequestMapping(value = "/testGuiaRemision/", method = RequestMethod.POST)
	public WayBillSchema testGuiaRemision(){
		
		OrderComplete oc = orderVitexService.getOrderComplete("648410909096-01");
		
		Catalog motoexpress = catalogService.findByNemonic("MOTO_EXPRESS");
		return datilService.processWayBill(oc,motoexpress,"SEQ_WAY_BILL_MOTOEXPRESS");
	}
	
}
