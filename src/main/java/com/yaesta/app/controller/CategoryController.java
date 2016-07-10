package com.yaesta.app.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.persistence.entity.Category;
import com.yaesta.persistence.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Category>> getAll(){
		
		List<Category> found = categoryService.getCategories();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Category>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Category>>(new ArrayList<Category>(),HttpStatus.OK);
	    }
	}

}
