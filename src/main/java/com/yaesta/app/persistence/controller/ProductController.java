package com.yaesta.app.persistence.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.service.ProductService;
import com.yaesta.integration.vitex.service.ProductVitexService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductVitexService productVitexService;
	
	
	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public  ResponseEntity<List<Product>> getAll(){
		
		List<Product> found = productService.getProducts();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Product>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Product>>(new ArrayList<Product>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/getProductFromVitex/{productId}", method = RequestMethod.GET)
	public  ResponseEntity<Product> getProductFromVitex(@PathVariable("productId")Integer productId){
		
		Product found = productVitexService.getVitexProduct(productId);
	
	    if(found!=null){
	    	return new ResponseEntity<Product>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<Product>(new Product(),HttpStatus.OK);
	    }
	}
	
	public ResponseEntity<Product> saveProduct(Product product){
		
		//create or save a Product
		Product result = productService.saveProduct(product, product.getSkuList());
	
		//LLamar al servicio de Vtex
		
	    return new ResponseEntity<Product>(result, HttpStatus.OK);
	}
}
