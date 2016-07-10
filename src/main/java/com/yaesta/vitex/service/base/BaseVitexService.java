package com.yaesta.vitex.service.base;

import java.io.Serializable;

import javax.xml.bind.JAXBContext;

import com.yaesta.vitex.wsdl.ObjectFactory;



public class BaseVitexService implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7480974848937514686L;
	

	public JAXBContext context=JAXBContext.newInstance();
	
	public ObjectFactory objectFactory =new ObjectFactory();
	
	public BaseVitexService () throws Exception{}

}
