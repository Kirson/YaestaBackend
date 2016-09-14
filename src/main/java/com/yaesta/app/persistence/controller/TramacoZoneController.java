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


import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.service.TramacoZoneService;
import com.yaesta.app.persistence.vo.TramacoZoneVO;

@RestController
@RequestMapping(value = "/tramacoZone")
public class TramacoZoneController {

	@Autowired
	TramacoZoneService tramacoZoneService;
	
	
	@RequestMapping(value = "/findByProvinciaCantonParroquia/{provincia}/{canton}/{parroquia}/", method = RequestMethod.GET)
	public ResponseEntity<TramacoZone> findByProvinciaCantonParroquia(@PathVariable("provincia") String provincia,@PathVariable("canton") String canton,@PathVariable("parroquia") String parroquia){
		TramacoZone found = tramacoZoneService.getByProvinciaCantonParroquia(provincia.toUpperCase(), canton.toUpperCase(), parroquia.toUpperCase());
		
		if(found!=null){
			return new ResponseEntity<TramacoZone>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<TramacoZone>(new TramacoZone(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<TramacoZone>> getAll(){
		
		List<TramacoZone> found = tramacoZoneService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<TramacoZone>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<TramacoZone>>(new ArrayList<TramacoZone>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<TramacoZone> update(@RequestBody TramacoZoneVO zoneVO){
		
		TramacoZone response = tramacoZoneService.save(zoneVO.getZone());
		
		return new ResponseEntity<TramacoZone>(response,HttpStatus.OK);
	}
}

