package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

/**
 * 
 * @author cristhian
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuideInfoBean implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4355287434095411083L;
	private OrderComplete orderComplete;
	private List<SupplierDeliveryInfo> supplierDeliveryInfoList;
	private List<GuideDTO> guides;
	private String error;
	private List<String> guideIdList;
	private List<String> errorList;
	private List<String> pdfPathList;
	
	public GuideInfoBean(){
		error="OK";
		guideIdList = new ArrayList<String>();
		errorList = new ArrayList<String>();
		pdfPathList = new ArrayList<String>();
	}
	
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}
	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}
	public List<SupplierDeliveryInfo> getSupplierDeliveryInfoList() {
		return supplierDeliveryInfoList;
	}
	public void setSupplierDeliveryInfoList(List<SupplierDeliveryInfo> supplierDeliveryInfoList) {
		this.supplierDeliveryInfoList = supplierDeliveryInfoList;
	}
	public List<GuideDTO> getGuides() {
		return guides;
	}
	public void setGuides(List<GuideDTO> guides) {
		this.guides = guides;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getGuideIdList() {
		return guideIdList;
	}

	public void setGuideIdList(List<String> guideIdList) {
		this.guideIdList = guideIdList;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<String> getPdfPathList() {
		return pdfPathList;
	}

	public void setPdfPathList(List<String> pdfPathList) {
		this.pdfPathList = pdfPathList;
	}
	
	
}
