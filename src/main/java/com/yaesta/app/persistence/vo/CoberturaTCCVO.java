package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.CoberturaTCC;

public class CoberturaTCCVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5078714498184246336L;
	private CoberturaTCC zone;

	public CoberturaTCC getZone() {
		return zone;
	}

	public void setZone(CoberturaTCC zone) {
		this.zone = zone;
	}
	
	
}
