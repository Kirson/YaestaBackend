package com.yaesta.integration.vitex.service.base;

import java.io.Serializable;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.yaesta.integration.vitex.wsdl.ObjectFactory;



public class BaseVitexService implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7480974848937514686L;
	
	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	protected @Value("${vitex.rest.url}") String vitexRestUrl;
	protected @Value("${vitex.rest.appkey.name}") String vitexRestAppkeyName;
	protected @Value("${vitex.rest.token.name}") String vitexRestTokenName;
	protected @Value("${vitex.rest.appkey}") String vitexRestAppkey;
	protected @Value("${vitex.rest.token}") String vitexRestToken;
	

	public JAXBContext context=JAXBContext.newInstance();
	
	public ObjectFactory objectFactory =new ObjectFactory();
	
	public BaseVitexService () throws Exception{}

}
