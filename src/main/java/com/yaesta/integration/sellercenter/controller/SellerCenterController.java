package com.yaesta.integration.sellercenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.sellercenter.json.bean.SellerUser;
import com.yaesta.integration.sellercenter.service.SellerCenterService;

@Controller
@Api(name = "SELLER CENTER API", 
     description = "Methods for managing SELLER CENTER INTEGRATION", 
     group = "Integration",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
@RestController
@RequestMapping(value = "/sellerCenterIntegration")
public class SellerCenterController {
	
	@Autowired
	SellerCenterService sellerCenterService;
	
	@ApiMethod(description="Get all SELLER users",
			   path="/sellerCenterIntegration/getSellerUsers",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/getSellerUsers", method = RequestMethod.GET)
	public @ApiResponseObject ResponseEntity<List<SellerUser>> getSellerUsers(){
		
		List<SellerUser> found = sellerCenterService.getSellerUsers();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<SellerUser>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<SellerUser>>(new ArrayList<SellerUser>(),HttpStatus.OK);
	    }
	}

}
