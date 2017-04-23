package com.yaesta.app.persistence.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.service.ClientService;
import com.yaesta.app.persistence.vo.ClientResponseVO;
import com.yaesta.app.persistence.vo.ClientVO;
import com.yaesta.app.persistence.vo.ClientWarehouseVO;

@RestController
@RequestMapping(value = "/client")
public class ClientController implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -6996880275325906054L;
	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public ResponseEntity<String> updateInfo(){
		
		@SuppressWarnings("deprecation")
		String response= clientService.updateInfo();
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAll(){
		
		List<Customer> list = clientService.getClients();
		
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCustomer/{document}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(String document){
		
		Customer found = clientService.findByDocument(document);
		
		return new ResponseEntity<Customer>(found, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllPageable/{page}/{size}", method = RequestMethod.GET)
	public ResponseEntity<Page<Customer>> getAllPageable(@PathVariable("page")Long page,@PathVariable("size") Long size){
		
		if(page==null){
			page=1L;
		}
		
		if(size==null){
			size=100L;
		}
		
		Pageable pageable = new PageRequest(page.intValue(), size.intValue());
		
		Page<Customer> list = clientService.getAll(pageable);
		
		return new ResponseEntity<Page<Customer>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNewClient", method = RequestMethod.GET)
	public ResponseEntity<List<ClientWarehouseVO>> getNewClient(){
		List<ClientWarehouseVO> list = clientService.getNewClient();
		return new ResponseEntity<List<ClientWarehouseVO>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllVO", method = RequestMethod.GET)
	public ResponseEntity<List<ClientVO>> getAllVO(){
		
		List<ClientVO> list = clientService.getAllVO();
		
		return new ResponseEntity<List<ClientVO>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateWarehouseClient", method = RequestMethod.GET)
	public ResponseEntity<ClientResponseVO> updateWarehouseClient(){
		ClientResponseVO crv = clientService.updateWarehouseClient();
		
		return new ResponseEntity<ClientResponseVO>(crv,HttpStatus.OK);
		
	}
}
