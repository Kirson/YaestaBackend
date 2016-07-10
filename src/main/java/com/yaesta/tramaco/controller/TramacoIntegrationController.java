package com.yaesta.tramaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.tramaco.service.TramacoService;


@RestController
@RequestMapping(value = "/tramacoIntegration")
public class TramacoIntegrationController {

	@Autowired
	TramacoService tramacoService;
	
	@RequestMapping(value = "/authService/", method = RequestMethod.GET)
	public ResponseEntity<String> authService() {
		String result = tramacoService.authService();
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
