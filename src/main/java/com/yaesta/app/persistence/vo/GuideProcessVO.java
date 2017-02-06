package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.Date;

import com.yaesta.app.persistence.entity.GuideProcess;

public class GuideProcessVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7065184605385066313L;
	
	private Date processDate;
	private GuideProcess guideProcess;
	
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public GuideProcess getGuideProcess() {
		return guideProcess;
	}
	public void setGuideProcess(GuideProcess guideProcess) {
		this.guideProcess = guideProcess;
	}


	
}
