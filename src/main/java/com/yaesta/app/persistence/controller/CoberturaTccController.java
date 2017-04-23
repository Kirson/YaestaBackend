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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.CoberturaTCC;
import com.yaesta.app.persistence.service.CoberturaTCCService;
import com.yaesta.app.persistence.vo.CoberturaTCCVO;

@Controller
@Api(name = "CoberturaTCC API", 
     description = "Methods for managing TCC places", 
     group = "Persistence",
     visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "0.1", until = "1.0")
@ApiAuthNone
@RestController
@RequestMapping(value = "/coberturaTcc")
public class CoberturaTccController {

	@Autowired
	CoberturaTCCService coberturaTCCService;
	
	@ApiMethod(description="Get all TCC places",
			   path="/coberturaTcc/getAll",
			   produces = { MediaType.APPLICATION_JSON_VALUE }, 
			   consumes = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ApiResponseObject  ResponseEntity<List<CoberturaTCC>> getAll(){
		
		List<CoberturaTCC> found = coberturaTCCService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<CoberturaTCC>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<CoberturaTCC>>(new ArrayList<CoberturaTCC>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<CoberturaTCC> update(@RequestBody CoberturaTCCVO zoneVO){
		
		CoberturaTCC response = coberturaTCCService.save(zoneVO.getZone());
		
		return new ResponseEntity<CoberturaTCC>(response,HttpStatus.OK);
	}
}
