package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1572684201459191863L;
	private String provincia;
	private List<CantonVO> cantones;
	
	public ProvinciaVO(){
		cantones = new ArrayList<CantonVO>();
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<CantonVO> getCantones() {
		return cantones;
	}

	public void setCantones(List<CantonVO> cantones) {
		this.cantones = cantones;
	}
	
	
	
}
