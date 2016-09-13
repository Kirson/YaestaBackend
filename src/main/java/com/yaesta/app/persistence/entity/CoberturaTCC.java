package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cobertura_tcc",schema="yaesta")
public class CoberturaTCC implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -1652499717603252437L;
	
	@Id
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="parroquia")
	private String parroquia;
	
	@Column(name="canton")
	private String canton;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="activo")
	private String activo;
	
	@Column(name="cedi")
	private String cedi;
	
	@Column(name="tiempo_entrega")
	private String tiempoEntrega;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCedi() {
		return cedi;
	}

	public void setCedi(String cedi) {
		this.cedi = cedi;
	}

	public String getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(String tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}
	
	
}
