package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

import dmz.comercial.servicio.cliente.dto.RespuestaGenerarGuiaWs;
import dmz.comercial.servicio.cliente.dto.RespuestaGenerarPdfWs;
import dmz.comercial.servicio.cliente.dto.RespuestaTrackGuiaWs;



@XmlRootElement
public class GuideDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	private Guide guide;
	
	private OrderComplete orderComplete;
	
	private SupplierDTO supplierInfo;
	
	private RespuestaGenerarGuiaWs guideResponse;
	
	private RespuestaGenerarPdfWs guidePdfResponse;
	
	private RespuestaTrackGuiaWs guideTrackResponse;
	
	private String response;
	
	private String pdfUrl;
	
	private List<String> errorList;
	
	public GuideDTO(){
		errorList = new ArrayList<String>();
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public OrderComplete getOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}

	

	public RespuestaGenerarGuiaWs getGuideResponse() {
		return guideResponse;
	}

	public void setGuideResponse(RespuestaGenerarGuiaWs guideResponse) {
		this.guideResponse = guideResponse;
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

	public RespuestaGenerarPdfWs getGuidePdfResponse() {
		return guidePdfResponse;
	}

	public void setGuidePdfResponse(RespuestaGenerarPdfWs guidePdfResponse) {
		this.guidePdfResponse = guidePdfResponse;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public RespuestaTrackGuiaWs getGuideTrackResponse() {
		return guideTrackResponse;
	}

	public void setGuideTrackResponse(RespuestaTrackGuiaWs guideTrackResponse) {
		this.guideTrackResponse = guideTrackResponse;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
	
	
}
