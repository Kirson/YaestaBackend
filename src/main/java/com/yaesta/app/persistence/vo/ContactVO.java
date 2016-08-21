package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class ContactVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7671611422123039031L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String strName) {
		
		
		this.name = strName.trim();
	}
	
	
}
