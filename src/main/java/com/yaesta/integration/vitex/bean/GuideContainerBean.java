package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.integration.tramaco.dto.GuideDTO;

public class GuideContainerBean implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private List<GuideDTO> guides;
	private GuideInfoBean guideInfoBean;
	private String error="OK";
	
	public GuideContainerBean(){
		guides = new ArrayList<GuideDTO>();
	}
	
	public List<GuideDTO> getGuides() {
		return guides;
	}
	public void setGuides(List<GuideDTO> guides) {
		this.guides = guides;
	}
	public GuideInfoBean getGuideInfoBean() {
		return guideInfoBean;
	}
	public void setGuideInfoBean(GuideInfoBean guideInfoBean) {
		this.guideInfoBean = guideInfoBean;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
