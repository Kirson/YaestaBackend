package com.yaesta.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parameter",schema="yaesta")
public class Parameter implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -1156049170534123513L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_seq_gen")
	@SequenceGenerator(name = "parameter_seq_gen", sequenceName = "parameter_id_seq")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "nemonic")
	private String nemonic;
	
	@Column(name = "vitex_id")
	private String vitexId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNemonic() {
		return nemonic;
	}

	public void setNemonic(String nemonic) {
		this.nemonic = nemonic;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}
	

	
}
