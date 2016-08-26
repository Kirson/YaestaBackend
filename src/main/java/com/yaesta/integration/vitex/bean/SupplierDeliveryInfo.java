package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.integration.vitex.json.bean.ItemComplete;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierDeliveryInfo implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2085188475778543348L;
	private String supplierId;
	private Supplier supplier;
	private Date deliveryDate;
	private String strDeliveryDate;
	private Long packages;
	private List<ItemComplete> items;
	private Boolean selected;
	private Catalog delivery;
	private String deliveryId;
	
	
	public SupplierDeliveryInfo(){
		items = new ArrayList<ItemComplete>();
		packages = 1L;
		deliveryDate = new Date();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		strDeliveryDate = f.format(deliveryDate);
		selected = Boolean.TRUE;
	}
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Long getPackages() {
		return packages;
	}
	public void setPackages(Long packages) {
		this.packages = packages;
	}
	public List<ItemComplete> getItems() {
		return items;
	}
	public void setItems(List<ItemComplete> items) {
		this.items = items;
	}

	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}

	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Catalog getDelivery() {
		return delivery;
	}

	public void setDelivery(Catalog delivery) {
		this.delivery = delivery;
	}

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
	
}
