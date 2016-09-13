package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Guide;

public class GuideBeanVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3387056630068868153L;
	
	private Guide guide;

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	
	
}
