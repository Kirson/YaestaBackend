package com.yaesta.integration.bpm.activiti.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserActiviti implements Serializable
{
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String password;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
