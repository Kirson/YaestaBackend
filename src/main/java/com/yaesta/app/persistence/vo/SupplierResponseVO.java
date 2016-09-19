package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class SupplierResponseVO implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4649906215866761201L;
	private String response;
	private String error;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	

}
