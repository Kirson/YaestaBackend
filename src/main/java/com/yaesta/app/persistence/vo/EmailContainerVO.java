package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmailContainerVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 788160054156673526L;
	private List<EmailVO> emailList;
	
	public EmailContainerVO(){
		emailList = new ArrayList<EmailVO>();
	}

	public List<EmailVO> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailVO> emailList) {
		this.emailList = emailList;
	}
	
	
}
