package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class OrderUpdVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7851087967332635390L;
	private Long count;
	private String message;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
