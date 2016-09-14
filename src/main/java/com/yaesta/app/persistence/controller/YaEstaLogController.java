package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.service.YaEstaLogService;

@RestController
@RequestMapping(value = "/yaestalog")
public class YaEstaLogController {

	@Autowired
	YaEstaLogService yaEstaLogService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<YaEstaLog>> getAll(){
		
		List<YaEstaLog> found = yaEstaLogService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<YaEstaLog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<YaEstaLog>>(new ArrayList<YaEstaLog>(),HttpStatus.OK);
	    }
	}
}
