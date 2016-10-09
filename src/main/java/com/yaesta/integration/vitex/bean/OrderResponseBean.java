package com.yaesta.integration.vitex.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponseBean {

	private String response;
	private String orderIdVtex;
	private String message;
	private Long orderId;
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getOrderIdVtex() {
		return orderIdVtex;
	}
	public void setOrderIdVtex(String orderIdVtex) {
		this.orderIdVtex = orderIdVtex;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
}
