package com.yaesta.app.persistence.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Brand;
import com.yaesta.app.persistence.service.BrandService;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

	@Autowired
	BrandService brandService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Brand>> getAll(){
		
		List<Brand> found = brandService.getBrands();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Brand>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Brand>>(new ArrayList<Brand>(),HttpStatus.OK);
	    }
	}
	
}
