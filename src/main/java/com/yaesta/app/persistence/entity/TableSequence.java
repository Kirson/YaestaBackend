package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_sequence",schema="yaesta")
public class TableSequence implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4816032690457308366L;

	@Id
	@Column(name="seq_name")
	private String seqName;
	
	@Column(name="seq_next_value")
	private Long seqNextValue;
	
	@Column(name="seq_increment")
	private Long increment;
	
	@Column(name="seq_max_value")
	private Long seqMaxValue;
	
	@Column(name="seq_type")
	private String type;
	
	public TableSequence(){
		type = "VIRTUAL";
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public Long getSeqNextValue() {
		return seqNextValue;
	}

	public void setSeqNextValue(Long seqNextValue) {
		this.seqNextValue = seqNextValue;
	}

	public Long getIncrement() {
		return increment;
	}

	public void setIncrement(Long increment) {
		this.increment = increment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSeqMaxValue() {
		return seqMaxValue;
	}

	public void setSeqMaxValue(Long seqMaxValue) {
		this.seqMaxValue = seqMaxValue;
	}
	
	
}
