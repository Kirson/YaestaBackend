package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.integration.datil.json.bean.GuiaRemisionRespuesta;

public class WayBillSchema implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 3244190506531372756L;
	private List<GuiaRemisionRespuesta> guideList;
	private String errorCode;
	private List<String> errorList;
	private List<GuideRemisionContainer> guideContainerList;

	public WayBillSchema() {
		guideList = new ArrayList<GuiaRemisionRespuesta>();
		errorCode = "OK";
		errorList = new ArrayList<String>();
		guideContainerList = new ArrayList<GuideRemisionContainer>();
	}

	public List<GuiaRemisionRespuesta> getGuideList() {
		return guideList;
	}

	public void setGuideList(List<GuiaRemisionRespuesta> guideList) {
		this.guideList = guideList;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<GuideRemisionContainer> getGuideContainerList() {
		return guideContainerList;
	}

	public void setGuideContainerList(List<GuideRemisionContainer> guideContainerList) {
		this.guideContainerList = guideContainerList;
	}

}
