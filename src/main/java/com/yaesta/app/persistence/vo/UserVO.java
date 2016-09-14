package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.User;

public class UserVO implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7782855056719716271L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
