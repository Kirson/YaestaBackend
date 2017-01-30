package com.yaesta.app.persistence.vo;

import java.util.Date;

public class GuideSearchVO extends DateRangeVO {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6534990331635775492L;
	private String status;
	private Date deliveryDate;
	private String deliveryName;
	private Date programmedDate;
	private Date processDate;
	private String strDate;

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

	public Date getProgrammedDate() {
		return programmedDate;
	}

	public void setProgrammedDate(Date programmedDate) {
		this.programmedDate = programmedDate;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	
	

	
}
