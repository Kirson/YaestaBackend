package com.yaesta.integration.tcc.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class TccService implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 9222090543065657597L;

	@Autowired
	private WebServiceTemplate webServiceTemplateTCC;
	
	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;
	

	protected @Value("${tcc.service.user}") String tccServiceUser;
	protected @Value("${tcc.service.password}") String tccServicePassword;

}
