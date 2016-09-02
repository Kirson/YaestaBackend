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

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.service.GuideService;

@RestController
@RequestMapping(value = "/guide")
public class GuideController {

	@Autowired
	GuideService guideService;
	
	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public ResponseEntity<List<Guide>> getAll(){
		List<Guide> found = guideService.getAll();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Guide>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Guide>>(new ArrayList<Guide>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findByDeliveryName{deliveryName}", method = RequestMethod.GET)
	public ResponseEntity<List<Guide>> findByDeliveryName(@PathVariable("deliveryName") String deliveryName){
		List<Guide> found = guideService.findByDeliveryName(deliveryName);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Guide>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Guide>>(new ArrayList<Guide>(),HttpStatus.OK);
		}
	}
}
