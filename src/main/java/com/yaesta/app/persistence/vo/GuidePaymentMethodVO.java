package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Catalog;

public class GuidePaymentMethodVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2219577471530246982L;
	private Catalog delivery;
	private String deliveryName;
	private Catalog periode;
	private String pediodeValue;
	private String status;
	public Catalog getDelivery() {
		return delivery;
	}
	public void setDelivery(Catalog delivery) {
		this.delivery = delivery;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public Catalog getPeriode() {
		return periode;
	}
	public void setPeriode(Catalog periode) {
		this.periode = periode;
	}
	public String getPediodeValue() {
		return pediodeValue;
	}
	public void setPediodeValue(String pediodeValue) {
		this.pediodeValue = pediodeValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
