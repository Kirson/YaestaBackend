package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.TramacoZone;

public class TramacoZoneVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 436469198975192024L;
	private TramacoZone zone;

	public TramacoZone getZone() {
		return zone;
	}

	public void setZone(TramacoZone zone) {
		this.zone = zone;
	}
	
	
}
