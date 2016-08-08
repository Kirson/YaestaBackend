package com.yaesta.app.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Client;
import com.yaesta.app.persistence.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public ResponseEntity<String> updateInfo(){
		
		String response= clientService.updateInfo();
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAll(){
		
		List<Client> list = clientService.getClients();
		
		return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
	}
}
