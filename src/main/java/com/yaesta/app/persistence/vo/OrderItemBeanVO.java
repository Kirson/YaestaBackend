package com.yaesta.app.persistence.vo;

import java.io.Serializable;


import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"supplierName",
	"wayToPay",
	"vitexId",
	"orderSequence",
	"customerDocument",
	"customerCanton",
	"customerState",
	"customerName",
	"customerAddress",
	"customerPhone",
	"productKey",
	"productDescription",
	"unitPrice",
	"discount",
	"quantity",
	"price",
	"customerValue",
	"valueReceivables",
	"statusDescription",
	"orderDate",
	"deliveryName",
	"guideNumber",
	"invoiceNumber",
	"guideValue",
	"partialItemValue",
	"programmedDate"
})
public class OrderItemBeanVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4202802691407106070L;
	private String supplierName;
	private String wayToPay;
	private String vitexId;
	private String orderSequence;
	private String customerDocument;
	private String customerCanton;
	private String customerState;
	private String customerName;
	private String customerAddress;
	private String customerPhone;
	private String productKey;
	private String productDescription;
	private Double unitPrice;
	private Double discount;
	private Long quantity;
	private Double price;
	private Double customerValue;
	private Double valueReceivables;
	private String statusDescription;
	private String orderDate;
	private String deliveryName;
	private String guideNumber;
	private String invoiceNumber;
	private Double guideValue;
	private Double partialItemValue;
	private String programmedDate;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getWayToPay() {
		return wayToPay;
	}
	public void setWayToPay(String wayToPay) {
		this.wayToPay = wayToPay;
	}
	public String getVitexId() {
		return vitexId;
	}
	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}
	public String getOrderSequence() {
		return orderSequence;
	}
	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}
	public String getCustomerDocument() {
		return customerDocument;
	}
	public void setCustomerDocument(String customerDocument) {
		this.customerDocument = customerDocument;
	}
	public String getCustomerCanton() {
		return customerCanton;
	}
	public void setCustomerCanton(String customerCanton) {
		this.customerCanton = customerCanton;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCustomerValue() {
		return customerValue;
	}
	public void setCustomerValue(Double customerValue) {
		this.customerValue = customerValue;
	}
	public Double getValueReceivables() {
		return valueReceivables;
	}
	public void setValueReceivables(Double valueReceivables) {
		this.valueReceivables = valueReceivables;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Double getGuideValue() {
		return guideValue;
	}
	public void setGuideValue(Double guideValue) {
		this.guideValue = guideValue;
	}
	public Double getPartialItemValue() {
		return partialItemValue;
	}
	public void setPartialItemValue(Double partialItemValue) {
		this.partialItemValue = partialItemValue;
	}
	public String getProgrammedDate() {
		return programmedDate;
	}
	public void setProgrammedDate(String programmedDate) {
		this.programmedDate = programmedDate;
	}
	
	
}
