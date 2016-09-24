package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yaesta.app.persistence.entity.Catalog;
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
	
	private String error;
	private List<String> guideIdList;
	private List<String> errorList;
	private List<String> pdfPathList;
	private String customerAdditionalInfo;
	private String deliveryName;
	private Catalog motiveCancel;
	private String motiveCancelText;
	private Catalog deliverySelected;
	
	public GuideInfoBean(){
		error="OK";
		guideIdList = new ArrayList<String>();
		errorList = new ArrayList<String>();
		pdfPathList = new ArrayList<String>();
		customerAdditionalInfo = "";
		deliveryName = "TRAMACO";
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

	public String getCustomerAdditionalInfo() {
		return customerAdditionalInfo;
	}

	public void setCustomerAdditionalInfo(String customerAdditionalInfo) {
		this.customerAdditionalInfo = customerAdditionalInfo;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public Catalog getMotiveCancel() {
		return motiveCancel;
	}

	public void setMotiveCancel(Catalog motiveCancel) {
		this.motiveCancel = motiveCancel;
	}

	public String getMotiveCancelText() {
		return motiveCancelText;
	}

	public void setMotiveCancelText(String motiveCancelText) {
		this.motiveCancelText = motiveCancelText;
	}

	public Catalog getDeliverySelected() {
		return deliverySelected;
	}

	public void setDeliverySelected(Catalog deliverySelected) {
		this.deliverySelected = deliverySelected;
	}
	
	
	
}
