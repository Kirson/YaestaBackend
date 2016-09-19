package com.yaesta.integration.sellercenter.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.sellercenter.json.bean.SellerUser;
import com.yaesta.integration.sellercenter.service.SellerCenterService;

@RestController
@RequestMapping(value = "/sellerCenterIntegrationTest")
public class SellerCenterTestController {
	
	@Autowired
	SellerCenterService sellerCenterService;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public  ResponseEntity<SellerUser> createUser(){
		SellerUser su = new SellerUser();
		su.setName("cherrera");
		su.setPerfil("seller");
		su.setUsername("cherrera");
		su.setEMail("cristhian.herrera@gmail.com");
		su.setSellerId("(-300-)");
		
		su = sellerCenterService.createUser(su);
		
		return new ResponseEntity<SellerUser>(su,HttpStatus.OK);
	}

}
