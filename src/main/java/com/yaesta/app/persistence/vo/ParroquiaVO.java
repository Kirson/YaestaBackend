package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class ParroquiaVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4314756839832530674L;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
