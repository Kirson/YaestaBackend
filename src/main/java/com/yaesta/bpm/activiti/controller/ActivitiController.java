package com.yaesta.bpm.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.bpm.activiti.dto.UserActivitiDTO;

@RestController
@RequestMapping(value = "/activiBpm")
public class ActivitiController {

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${activiti.url}") String activitiUrl;
	private @Value("${activiti.admin.username}") String adminUserName;
	private @Value("${activiti.admin.password}") String adminPassword;
	
	@RequestMapping(value = "/getAdminUser", method = RequestMethod.GET)
	public ResponseEntity<UserActivitiDTO> getAdminUser(){
		UserActivitiDTO adminUser = new UserActivitiDTO();
		adminUser.setName(adminUserName);
		adminUser.setPassword(adminPassword);
		
		return new ResponseEntity<UserActivitiDTO>(adminUser,HttpStatus.OK);
	}
}
