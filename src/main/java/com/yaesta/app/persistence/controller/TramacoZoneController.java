package com.yaesta.app.persistence.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.service.TramacoZoneService;

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
}

