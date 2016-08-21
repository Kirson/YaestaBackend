package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactContainerVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7606087225510721369L;
	private List<ContactVO> contactList;

	public ContactContainerVO(){
		contactList = new ArrayList<ContactVO>();	
		}
	
	public List<ContactVO> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactVO> contactList) {
		this.contactList = contactList;
	}
	
	
}
