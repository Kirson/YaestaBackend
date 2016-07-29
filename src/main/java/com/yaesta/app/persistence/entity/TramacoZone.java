package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tramaco_ubicacion_geografica",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TramacoZone implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4166443607685163244L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tramaco_ubicacion_geografica_codigo_seq_gen")
	@SequenceGenerator(name = "tramaco_ubicacion_geografica_codigo_seq_gen", sequenceName = "tramaco_ubicacion_geografica_codigo_seq")
	private Long codigo;
	
	@Column(name="canton")
	private String canton;
	
	@Column(name="parroquia")
	private String parroquia;
	
	@Column(name="provincia")
	private String provincia;
	
	@Transient
	private String zona;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getZona() {
		zona = provincia + "-" + canton + "-" + parroquia;
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	
}
