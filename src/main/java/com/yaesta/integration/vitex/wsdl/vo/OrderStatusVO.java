package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;

public class OrderStatusVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1430745923179480271L;
	private String id;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
