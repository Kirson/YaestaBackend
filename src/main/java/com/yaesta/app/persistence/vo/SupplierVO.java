package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.entity.SupplierDeliveryCalendar;

public class SupplierVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -5790748112162698017L;
	
	private Supplier supplier;
	private List<SupplierDeliveryCalendar> deliveryCalendar;
	private List<SupplierContact> contactList;
	private List<SupplierContact> removeContactList;
	private SupplierContact contact;
	
	public SupplierVO(){
		contactList = new ArrayList<SupplierContact>();
		deliveryCalendar = new ArrayList<SupplierDeliveryCalendar>();
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<SupplierDeliveryCalendar> getDeliveryCalendar() {
		return deliveryCalendar;
	}

	public void setDeliveryCalendar(List<SupplierDeliveryCalendar> deliveryCalendar) {
		this.deliveryCalendar = deliveryCalendar;
	}

	public List<SupplierContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<SupplierContact> contactList) {
		this.contactList = contactList;
	}

	public List<SupplierContact> getRemoveContactList() {
		return removeContactList;
	}

	public void setRemoveContactList(List<SupplierContact> removeContactList) {
		this.removeContactList = removeContactList;
	}

	public SupplierContact getContact() {
		return contact;
	}

	public void setContact(SupplierContact contact) {
		this.contact = contact;
	}
	
	
	
	
}
