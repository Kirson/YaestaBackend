package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.service.CatalogService;
import com.yaesta.app.persistence.vo.CatalogVO;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Catalog>> getAll(){
		
		List<Catalog> found = catalogService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Catalog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Catalog>>(new ArrayList<Catalog>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/getMainCatalogs", method = RequestMethod.GET)
	public  ResponseEntity<List<Catalog>> getMainCatalogs(){
		
		List<Catalog> found = catalogService.getMainCatalogs();
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Catalog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Catalog>>(new ArrayList<Catalog>(),HttpStatus.OK);
	    }
	}
	
	
	@RequestMapping(value = "/getSubCatalogs{parentNemonic}", method = RequestMethod.GET)
	public  ResponseEntity<List<Catalog>> getSubCatalogs(@PathVariable("parentNemonic")String parentNemonic){
		
		List<Catalog> found = catalogService.findByParentNemonic(parentNemonic);
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Catalog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Catalog>>(new ArrayList<Catalog>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Catalog> save(@RequestBody CatalogVO catalogVO){
		
		Catalog response = catalogService.save(catalogVO.getCatalog(), catalogVO.getDetailList(), catalogVO.getRemoveList());
		
		return new ResponseEntity<Catalog>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCatalogByNemonic{nemonic}", method = RequestMethod.GET)
	public ResponseEntity<Catalog> getCatalogByNemonic(@PathVariable("nemonic")String nemonic){
		
		Catalog response = catalogService.findByNemonic(nemonic);
		
		return new ResponseEntity<Catalog>(response,HttpStatus.OK);
	}
}
