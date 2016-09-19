package com.yaesta.integration.sellercenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.sellercenter.json.bean.SellerUser;
import com.yaesta.integration.sellercenter.service.SellerCenterService;

@RestController
@RequestMapping(value = "/sellerCenterIntegration")
public class SellerCenterController {
	
	@Autowired
	SellerCenterService sellerCenterService;
	
	@RequestMapping(value = "/getSellerUsers", method = RequestMethod.GET)
	public  ResponseEntity<List<SellerUser>> getSellerUsers(){
		
		List<SellerUser> found = sellerCenterService.getSellerUsers();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<SellerUser>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<SellerUser>>(new ArrayList<SellerUser>(),HttpStatus.OK);
	    }
	}

}
