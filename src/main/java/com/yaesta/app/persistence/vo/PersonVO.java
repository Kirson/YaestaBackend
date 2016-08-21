package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class PersonVO  implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4272937036657292187L;
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
