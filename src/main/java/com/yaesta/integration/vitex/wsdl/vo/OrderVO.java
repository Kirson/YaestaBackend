package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderVO")
public class OrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2387162089557907177L;
	private Long id;
	private String vitexId;
	private String customerVitexId;
	private String customerFirstName;
	private String customerLastName;
	private String customerName;
	private String city;
	private BigDecimal cost;
	private String store;
	private Date purchaseDate;
	private List<OrderDeliveryVO> deliveries;
	
	public OrderVO(){
		deliveries=new ArrayList<OrderDeliveryVO>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVitexId() {
		return vitexId;
	}
	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}
	public String getCustomerVitexId() {
		return customerVitexId;
	}
	public void setCustomerVitexId(String customerVitexId) {
		this.customerVitexId = customerVitexId;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public List<OrderDeliveryVO> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(List<OrderDeliveryVO> deliveries) {
		this.deliveries = deliveries;
	}

	public String getCustomerName() {
		customerName = customerFirstName + " " + customerLastName;
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
}
