package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Guide;

public class GuideBeanVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3387056630068868153L;
	
	private Guide guide;
	private String status;
	private String message;

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
