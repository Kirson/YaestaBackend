package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.TableSequence;

public class TableSequenceResponseVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private TableSequence tableSequence;
	private Boolean insideLimit;
	private Long currentMaxValue;
	private Long marginValue;
	private Long currentValue;
	private Long diference;
	private String code;
	
	public TableSequence getTableSequence() {
		return tableSequence;
	}
	public void setTableSequence(TableSequence tableSequence) {
		this.tableSequence = tableSequence;
	}
	public Boolean getInsideLimit() {
		return insideLimit;
	}
	public void setInsideLimit(Boolean insideLimit) {
		this.insideLimit = insideLimit;
	}
	public Long getCurrentMaxValue() {
		return currentMaxValue;
	}
	public void setCurrentMaxValue(Long currentMaxValue) {
		this.currentMaxValue = currentMaxValue;
	}
	public Long getMarginValue() {
		return marginValue;
	}
	public void setMarginValue(Long marginValue) {
		this.marginValue = marginValue;
	}
	public Long getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}
	public Long getDiference() {
		return diference;
	}
	public void setDiference(Long diference) {
		this.diference = diference;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
