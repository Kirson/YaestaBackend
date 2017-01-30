package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yaesta.app.persistence.entity.GuideDetail;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"id",
	"guideNumber",
	"deliveryName",
	"customerName",
	"guideStatus",
	"deliveryStatus",
	"creationDate",
	"orderDate",
	"deliveryDate",
	"orderId",
	"supplierId",
	"supplierName",
	"programmedDate",
	"details"
})
public class GuideVO implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2778477755228635736L;
	private Long id;
	private String guideNumber;
	private String deliveryName;
	private String customerName;
	private String guideStatus;
	private String deliveryStatus;
	private Date creationDate;
	private Date orderDate;
	private Date deliveryDate;
	private String orderId;
	private Long supplierId;
	private String supplierName;
	private List<GuideDetail> details;
	private Date programmedDate;
	
	public GuideVO(){
		details = new ArrayList<GuideDetail>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getGuideStatus() {
		return guideStatus;
	}
	public void setGuideStatus(String guideStatus) {
		this.guideStatus = guideStatus;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<GuideDetail> getDetails() {
		return details;
	}

	public void setDetails(List<GuideDetail> details) {
		this.details = details;
	}

	public Date getProgrammedDate() {
		return programmedDate;
	}

	public void setProgrammedDate(Date programmedDate) {
		this.programmedDate = programmedDate;
	}
	
	

}
