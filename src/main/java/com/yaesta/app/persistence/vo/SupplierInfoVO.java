package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Supplier;

public class SupplierInfoVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7865335908800693636L;
	private Supplier supplier;
	private Catalog category;
	private Catalog bank;
	private Catalog accountType;
	private Catalog productListStatus;
	private Catalog supplierStatus;
	private Catalog priority;
	private Catalog supplierType;
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Catalog getCategory() {
		return category;
	}
	public void setCategory(Catalog category) {
		this.category = category;
	}
	public Catalog getBank() {
		return bank;
	}
	public void setBank(Catalog bank) {
		this.bank = bank;
	}
	public Catalog getAccountType() {
		return accountType;
	}
	public void setAccountType(Catalog accountType) {
		this.accountType = accountType;
	}
	public Catalog getProductListStatus() {
		return productListStatus;
	}
	public void setProductListStatus(Catalog productListStatus) {
		this.productListStatus = productListStatus;
	}
	public Catalog getSupplierStatus() {
		return supplierStatus;
	}
	public void setSupplierStatus(Catalog supplierStatus) {
		this.supplierStatus = supplierStatus;
	}
	public Catalog getPriority() {
		return priority;
	}
	public void setPriority(Catalog priority) {
		this.priority = priority;
	}
	public Catalog getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(Catalog supplierType) {
		this.supplierType = supplierType;
	}
	
	
}
