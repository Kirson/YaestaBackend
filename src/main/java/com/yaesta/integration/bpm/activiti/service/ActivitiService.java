package com.yaesta.integration.bpm.activiti.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;


import com.yaesta.integration.bpm.activiti.bean.UserActiviti;

@Service
public class ActivitiService {
	
	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${activiti.url}") String activitiUrl;
	
	private Client client;
	private WebTarget target;
	
	public UserActiviti authActiviti(String userId,String password){
		
		client = ClientBuilder.newClient();
		
		String url = activitiUrl+"service/login";
		
		target = client.target(url);
		
		UserActiviti ua = new UserActiviti();
		ua.setUserId(userId);
		ua.setPassword(password);
		
		//Response response = target.request().put(Entity.json(ua));
		Response response= target.request().put(Entity.json(ua));
		System.out.println("-->>"+response.toString());
		return ua;
	}
}
