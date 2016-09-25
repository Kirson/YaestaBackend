package com.yaesta.app.pdf.bean;

import java.io.Serializable;

public class ItemData implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -5406003953297569492L;
	private String name;
	private String quantity;
	private String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
