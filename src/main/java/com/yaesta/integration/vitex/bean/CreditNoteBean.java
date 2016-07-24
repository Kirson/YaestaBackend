package com.yaesta.integration.vitex.bean;

import java.io.Serializable;

import com.yaesta.integration.vitex.json.bean.OrderComplete;

public class CreditNoteBean implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3789772147274849757L;
	private OrderComplete orderComplete;
	private String documentNumber;
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}
	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	
	
}
