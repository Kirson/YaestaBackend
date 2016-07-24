package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Parameter;
import com.yaesta.app.persistence.service.ParameterService;

@RestController
@RequestMapping(value = "/parameter")
public class ParameterController {

	@Autowired
	ParameterService parameterService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Parameter>> getAll(){
		
		List<Parameter> found = parameterService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Parameter>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Parameter>>(new ArrayList<Parameter>(),HttpStatus.OK);
	    }
	}
}
