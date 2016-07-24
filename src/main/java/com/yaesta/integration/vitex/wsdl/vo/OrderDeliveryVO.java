package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderDeliveryVO")
public class OrderDeliveryVO implements Serializable
{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -8805724329553520530L;
	
	private String freightName;
	private String freightId;
	private Date deliveryDate;
	private String orderStatusDescription;
	private String orderStatusCode;
	private List<OrderItemVO> items;
	private List<SellerVO> sellers;
	
	public OrderDeliveryVO(){
		items= new ArrayList<OrderItemVO>();
		sellers = new ArrayList<SellerVO>();
	}
	
	public String getFreightName() {
		return freightName;
	}
	public void setFreightName(String freightName) {
		this.freightName = freightName;
	}
	public String getFreightId() {
		return freightId;
	}
	public void setFreightId(String freightId) {
		this.freightId = freightId;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	


	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}

	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public List<OrderItemVO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemVO> items) {
		this.items = items;
	}

	public List<SellerVO> getSellers() {
		return sellers;
	}

	public void setSellers(List<SellerVO> sellers) {
		this.sellers = sellers;
	}
	
	
	
}
