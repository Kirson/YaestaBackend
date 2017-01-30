package com.yaesta.app.pdf.bean;

import java.io.Serializable;

public class GuideProcessBean implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String dateProcess;
	private Long count;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateProcess() {
		return dateProcess;
	}
	public void setDateProcess(String dateProcess) {
		this.dateProcess = dateProcess;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
