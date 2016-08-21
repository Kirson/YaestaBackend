package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.TableSequence;

public class TableSequenceVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 376866326422326227L;
	private TableSequence tableSequence;

	public TableSequence getTableSequence() {
		return tableSequence;
	}

	public void setTableSequence(TableSequence tableSequence) {
		this.tableSequence = tableSequence;
	}
	
	
}
