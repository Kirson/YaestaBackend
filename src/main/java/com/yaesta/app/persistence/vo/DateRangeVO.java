package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.Date;

public class DateRangeVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7576257334283690871L;
	protected Date startDate;
	protected Date finishDate;
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	
}
