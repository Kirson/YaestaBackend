package com.yaesta.app.persistence.controller;


import java.util.ArrayList;
import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.service.TramacoZoneService;
import com.yaesta.app.persistence.vo.TramacoZoneVO;

@Controller
@Api(name = "TRAMACO ZONE API", 
     description = "Methods for managing TRAMACO places", 
     group = "Persistence",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
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
	
	@ApiMethod(description="Get all TRAMACO places",
			   path="/tramacoZone/getAll",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ApiResponseObject  ResponseEntity<List<TramacoZone>> getAll(){
		
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

