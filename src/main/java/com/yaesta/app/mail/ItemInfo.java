package com.yaesta.app.mail;

import java.io.Serializable;

public class ItemInfo implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4937448085916455345L;
	private String name;
	private Double price;
	private String url;
	private String refCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRefCode() {
		return refCode;
	}
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	
	
}
