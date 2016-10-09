package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class GuideDeliveryNotificationVO implements Serializable {

	private String response;
	private List<String> courierList;
	
	public GuideDeliveryNotificationVO(){
		courierList = new ArrayList<String>();
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<String> getCourierList() {
		return courierList;
	}
	public void setCourierList(List<String> courierList) {
		this.courierList = courierList;
	}
	
	
	
}
