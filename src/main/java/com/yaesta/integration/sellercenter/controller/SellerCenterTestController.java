package com.yaesta.integration.sellercenter.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.yaesta.integration.sellercenter.json.bean.UserBean;
import com.yaesta.integration.sellercenter.json.bean.UserResponseContainer;
import com.yaesta.integration.sellercenter.service.SellerCenterService;

@RestController
@RequestMapping(value = "/sellerCenterIntegrationTest")
public class SellerCenterTestController {
	
	@Autowired
	SellerCenterService sellerCenterService;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public  ResponseEntity<UserResponseContainer> createUser(){
		UserBean su = new UserBean();
		su.setUsuario("cherrera");
		su.setPerfil("seller");
		su.setNombre("Cristhian Herrera");
		su.setEmail("cristhian.herrera@gmail.com");
		su.setId("(-3000-)");
		
		UserResponseContainer resp = sellerCenterService.createUser(su);
		
		return new ResponseEntity<UserResponseContainer>(resp,HttpStatus.OK);
	}

}
