package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CantonVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 2560611244408193971L;

	private String nombre;
	
	private List<ParroquiaVO> parroquias;
	
	public CantonVO(){
		parroquias = new ArrayList<ParroquiaVO>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ParroquiaVO> getParroquias() {
		return parroquias;
	}

	public void setParroquias(List<ParroquiaVO> parroquias) {
		this.parroquias = parroquias;
	}
	
	
}
