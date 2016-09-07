package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.integration.vitex.json.bean.ItemComplete;

public class GuideVtexVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 742114867315405953L;
	private String supplierVitexId;
	private Supplier supplier;
	private List<ItemComplete> items;
	
	public GuideVtexVO(){
		items = new ArrayList<ItemComplete>();
	}

	public String getSupplierVitexId() {
		return supplierVitexId;
	}

	public void setSupplierVitexId(String supplierVitexId) {
		this.supplierVitexId = supplierVitexId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<ItemComplete> getItems() {
		return items;
	}

	public void setItems(List<ItemComplete> items) {
		this.items = items;
	}
	
	
}
