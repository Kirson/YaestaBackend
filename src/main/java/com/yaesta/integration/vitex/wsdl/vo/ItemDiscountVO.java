package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDiscountVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6046625908659160880L;
	private String id;
	private String description;
	private BigDecimal value;
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
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
