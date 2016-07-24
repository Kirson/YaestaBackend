package com.yaesta.integration.bpm.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.bpm.activiti.bean.UserActiviti;
import com.yaesta.integration.bpm.activiti.service.ActivitiService;

@RestController
@RequestMapping(value = "/activiBpm")
public class ActivitiController {

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	ActivitiService activitiService;

	private @Value("${activiti.url}") String activitiUrl;
	private @Value("${activiti.admin.username}") String adminUserName;
	private @Value("${activiti.admin.password}") String adminPassword;
	
	@RequestMapping(value = "/getAdminUser", method = RequestMethod.GET)
	public ResponseEntity<UserActiviti> getAdminUser(){
		UserActiviti adminUser = new UserActiviti();
		adminUser.setUserId(adminUserName);
		adminUser.setPassword(adminPassword);
		
		return new ResponseEntity<UserActiviti>(adminUser,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authActiviti{userPassword}", method = RequestMethod.GET)
	public UserActiviti authActiviti(@PathVariable("userPassword")String userPassword){
		String [] userInfo = userPassword.split(":");
		return activitiService.authActiviti(userInfo[0], userInfo[1]);
	}
}
