package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProcessVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 181120444594915189L;
	private String result;
	private Long count;
	private List<String> exceptionList;
	
	public UserProcessVO(){
		exceptionList = new ArrayList<String>();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<String> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<String> exceptionList) {
		this.exceptionList = exceptionList;
	}
	
	
}
