package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.yaesta.integration.vitex.json.bean.OrderComplete;


@XmlRootElement
public class GuideDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	
	private OrderComplete orderComplete;
	private SupplierDTO supplierInfo;
	private List<GuideBeanDTO> guideBeanList;
	private String response;
	private List<String> errorList;
	private String customerAdditionalInfo;
	private GuideBeanDTO guideBean;
	private Integer packages;
	
	
	public GuideDTO(){
		packages = 1;
		errorList = new ArrayList<String>();
		guideBeanList = new ArrayList<GuideBeanDTO>();
	}

	
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}

	

	

	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public SupplierDTO getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(SupplierDTO supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	
	

	public List<GuideBeanDTO> getGuideBeanList() {
		return guideBeanList;
	}


	public void setGuideBeanList(List<GuideBeanDTO> guideBeanList) {
		this.guideBeanList = guideBeanList;
	}


	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public String getCustomerAdditionalInfo() {
		return customerAdditionalInfo;
	}

	public void setCustomerAdditionalInfo(String customerAdditionalInfo) {
		this.customerAdditionalInfo = customerAdditionalInfo;
	}


	public GuideBeanDTO getGuideBean() {
		return guideBean;
	}


	public void setGuideBean(GuideBeanDTO guideBean) {
		this.guideBean = guideBean;
	}


	public Integer getPackages() {
		return packages;
	}


	public void setPackages(Integer packages) {
		this.packages = packages;
	}

	
	
	
	
}
