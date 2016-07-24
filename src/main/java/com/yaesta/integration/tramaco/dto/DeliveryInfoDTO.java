package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yaesta.integration.vitex.json.bean.ItemComplete;

public class DeliveryInfoDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2408852453826095965L;
	
	private Long packages;
	private Date deliveryDate;
	private List<ItemComplete> itemList;
	
	public Long getPackages() {
		return packages;
	}
	public void setPackages(Long packages) {
		this.packages = packages;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public List<ItemComplete> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemComplete> itemList) {
		this.itemList = itemList;
	}
	
	
}
