package com.yaesta.app.persistence.vo;

import java.util.Date;

public class GuideSearchVO extends DateRangeVO  {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6534990331635775492L;
	private String status;
	private Date deliveryDate;
	private String deliveryName;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	
	
}
