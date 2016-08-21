package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhoneVO implements Serializable {

	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 499024869848721767L;
	private String phone;
	private List<String> ext;
	
	public PhoneVO(){
		ext = new ArrayList<String>();
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String strPhone) {
		
		if(strPhone.startsWith("9")){
			strPhone = "0"+strPhone;
		}
		
		while(strPhone.length()<9){
			strPhone = "0"+strPhone;
		}
		
		
		
		this.phone = strPhone;
	}
	public List<String> getExt() {
		return ext;
	}
	public void setExt(List<String> ext) {
		this.ext = ext;
	}
	
	
	
}
