package com.yaesta.app.mail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemInfoSupplier implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 2328924113664422814L;
	private String supplierName;
	private String supplierAddress;
	private String principalContact;
	private String contactNames;
	private List<String> contacts;
	private String city;
	private String phone;
	private String guideNumber;
	
	public ItemInfoSupplier(){
		contacts = new ArrayList<String>();
	}
	
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getPrincipalContact() {
		return principalContact;
	}
	public void setPrincipalContact(String principalContact) {
		this.principalContact = principalContact;
	}
	public String getContactNames() {
		return contactNames;
	}
	public void setContactNames(String contactNames) {
		this.contactNames = contactNames;
	}
	public List<String> getContacts() {
		return contacts;
	}
	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGuideNumber() {
		return guideNumber;
	}
	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}
	
	

}
