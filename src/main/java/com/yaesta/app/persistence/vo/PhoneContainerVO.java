package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhoneContainerVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3703237931556505565L;
	private List<PhoneVO> phoneList;
	
	public PhoneContainerVO(){
		phoneList = new ArrayList<PhoneVO>();
	}

	public List<PhoneVO> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneVO> phoneList) {
		this.phoneList = phoneList;
	}
	
	
}
