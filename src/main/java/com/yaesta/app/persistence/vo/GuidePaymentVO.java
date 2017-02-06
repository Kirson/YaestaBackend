package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"id",
	"orderNumber",
	"guideNumber",
	"status",
	"deliveryName",
	"supplierName",
	"customerName",
	"orderDate",
	"guideValue"
})
public class GuidePaymentVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7354566918452649750L;
	private String id;
	private String orderNumber;
	private String guideNumber;
	private String status;
	private String deliveryName;
	private String supplierName;
	private String customerName;
	private String orderDate;
	private String guideValue;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	
	
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getGuideValue() {
		return guideValue;
	}
	public void setGuideValue(String guideValue) {
		this.guideValue = guideValue;
	}
	
	
}
