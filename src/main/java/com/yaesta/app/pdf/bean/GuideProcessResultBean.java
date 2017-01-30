package com.yaesta.app.pdf.bean;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.GuideProcess;

public class GuideProcessResultBean implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private GuideProcess guideProcess;
	private Boolean isOk;
	private String message;
	
	public GuideProcessResultBean(){
		isOk = Boolean.TRUE;
	}

	public GuideProcess getGuideProcess() {
		return guideProcess;
	}

	public void setGuideProcess(GuideProcess guideProcess) {
		this.guideProcess = guideProcess;
	}

	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
