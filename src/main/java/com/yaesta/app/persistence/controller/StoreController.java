package com.yaesta.app.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Store;
import com.yaesta.app.persistence.service.StoreService;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	
	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public  ResponseEntity<List<Store>> getAll(){
		
		List<Store> found = storeService.getStores();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Store>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Store>>(new ArrayList<Store>(),HttpStatus.OK);
	    }
	}
}
