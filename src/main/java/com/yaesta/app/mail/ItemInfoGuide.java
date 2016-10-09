package com.yaesta.app.mail;

import java.io.Serializable;

public class ItemInfoGuide implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7205519463761016822L;
	private String supplierName;
	private String customerName;
	private String customerPhone;
	private String orderId;
	private String orderSequence;
	private String guideNumber;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderSequence() {
		return orderSequence;
	}
	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	
	
}
