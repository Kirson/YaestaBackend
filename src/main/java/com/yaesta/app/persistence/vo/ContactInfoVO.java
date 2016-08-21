package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactInfoVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7452145090730969002L;
	private PersonVO principalContact;
	private List<ContactVO> contactList;
	private PhoneVO principalPhone;
	private List<PhoneVO> phoneList;
	private EmailVO principalEmail;
	private List<EmailVO> emailList;
	
	public ContactInfoVO(){
		contactList = new ArrayList<ContactVO>();
		phoneList = new ArrayList<PhoneVO>();
		emailList = new ArrayList<EmailVO>();
	}

	public PersonVO getPrincipalContact() {
		return principalContact;
	}

	public void setPrincipalContact(PersonVO principalContact) {
		this.principalContact = principalContact;
	}

	public List<ContactVO> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactVO> contactList) {
		this.contactList = contactList;
	}

	public PhoneVO getPrincipalPhone() {
		return principalPhone;
	}

	public void setPrincipalPhone(PhoneVO principalPhone) {
		this.principalPhone = principalPhone;
	}

	public List<PhoneVO> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneVO> phoneList) {
		this.phoneList = phoneList;
	}

	public EmailVO getPrincipalEmail() {
		return principalEmail;
	}

	public void setPrincipalEmail(EmailVO principalEmail) {
		this.principalEmail = principalEmail;
	}

	public List<EmailVO> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailVO> emailList) {
		this.emailList = emailList;
	}
	
	
}
