package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class GfkVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1550510795763161599L;
	private String store;
	private String itemId;
	private String sku;
	private String description;
	private String brand;
	private String category;
	private Long itemsSold;
	private Double total;
	private String periode;
	
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getItemsSold() {
		return itemsSold;
	}
	public void setItemsSold(Long itemsSold) {
		this.itemsSold = itemsSold;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	
}
