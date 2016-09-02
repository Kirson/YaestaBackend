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

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.service.AddressService;
import com.yaesta.app.persistence.service.SupplierService;
import com.yaesta.app.persistence.service.TramacoZoneService;
import com.yaesta.app.persistence.vo.SupplierVO;
import com.yaesta.app.persistence.vo.ProvinciaVO;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	TramacoZoneService tramacoZoneService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Supplier>> getAll(){
		
		List<Supplier> found = supplierService.getSuppliers();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Supplier>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Supplier>>(new ArrayList<Supplier>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/getContacts{supplierId}", method = RequestMethod.GET)
	public  ResponseEntity<List<SupplierContact>> getContacts(@PathVariable("supplierId") Long supplierId){
		
		List<SupplierContact> found = null;
		Supplier supplier = supplierService.findById(supplierId);
		
		if(supplier!=null){
		
		 found = supplierService.getContacts(supplier);
	
		}
		
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<SupplierContact>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<SupplierContact>>(new ArrayList<SupplierContact>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public ResponseEntity<String> updateInfo(){
		
		String response= supplierService.updateSupplierFromAddress();
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.GET)
	public ResponseEntity<String> updateSupplier(){
		
		String response= supplierService.updateSupplier();
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateContacts", method = RequestMethod.GET)
	public ResponseEntity<String> updateContacts(){
		
		String response= supplierService.updateContacts();
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Supplier> create(@RequestBody SupplierVO supplierVO){
		
		Supplier response = supplierService.save(supplierVO.getSupplier(), null,supplierVO.getContactList(),null);
		
		return new ResponseEntity<Supplier>(response,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/removeContact", method = RequestMethod.POST)
	public ResponseEntity<String> removeContact(@RequestBody SupplierVO supplierVO){
		String response = "OK";
		 
		supplierService.removeContact(supplierVO.getContact());
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Supplier> update(@RequestBody SupplierVO supplierVO){
		
		Supplier response = supplierService.save(supplierVO.getSupplier(), null, supplierVO.getContactList(),supplierVO.getRemoveContactList());
		
		return new ResponseEntity<Supplier>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getZones", method = RequestMethod.GET)
	public  ResponseEntity<List<ProvinciaVO>> getZones(){
		
		List<ProvinciaVO> found = tramacoZoneService.findZones();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<ProvinciaVO>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<ProvinciaVO>>(new ArrayList<ProvinciaVO>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/getTramacoZones", method = RequestMethod.GET)
	public  ResponseEntity<List<TramacoZone>> getTramacoZones(){
		
		List<TramacoZone> found = tramacoZoneService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<TramacoZone>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<TramacoZone>>(new ArrayList<TramacoZone>(),HttpStatus.OK);
	    }
	}

}
