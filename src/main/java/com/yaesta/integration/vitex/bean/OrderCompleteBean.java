package com.yaesta.integration.vitex.bean;

import java.io.Serializable;

import com.yaesta.integration.vitex.json.bean.OrderComplete;

public class OrderCompleteBean implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2559227165489542195L;
	private OrderComplete order;
	private String action;
	public OrderComplete getOrder() {
		return order;
	}
	public void setOrder(OrderComplete order) {
		this.order = order;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	
}
