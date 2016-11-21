package com.yaesta.integration.vitex.bean;

import java.io.Serializable;

public class PaymentBean implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -245861515180983037L;
	private String paymentMethod;
	private String description;
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
