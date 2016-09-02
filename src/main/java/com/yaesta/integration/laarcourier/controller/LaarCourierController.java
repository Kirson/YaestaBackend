package com.yaesta.integration.laarcourier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.laarcourier.service.LaarCourierService;
import com.yaesta.integration.laarcourier.wsdl.WayBillResponse;
import com.yaesta.integration.vitex.bean.OrderCompleteBean;

@RestController
@RequestMapping(value = "/laarCourierIntegration")
public class LaarCourierController {
	
	@Autowired
	LaarCourierService laarCourierService;
	
	@RequestMapping(value = "/wayBill", method = RequestMethod.POST)
	public ResponseEntity<WayBillResponse> wayBill(@RequestBody OrderCompleteBean orderCompleteBean) {
		
		WayBillResponse response = laarCourierService.processWayBill(orderCompleteBean.getOrder());
		
		return new ResponseEntity<WayBillResponse>(response,HttpStatus.OK);
	}

}
