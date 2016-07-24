package com.yaesta.integration.bpm.jbpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.bpm.jbpm.service.JBPMService;

@RestController
@RequestMapping(value = "/authjbpm")
public class AuthJBPMController {

	@Autowired
	JBPMService jbpmService;
	
	@RequestMapping(value = "/getUserJBPM/{user}", method = RequestMethod.GET)
	public  ResponseEntity<String> getUserJBPM(@PathVariable("user") String user) throws Exception{
		
		String res = jbpmService.getTaskSummaryList();
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
}
