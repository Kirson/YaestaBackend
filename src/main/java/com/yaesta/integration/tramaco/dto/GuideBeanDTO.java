package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.integration.vitex.json.bean.ItemComplete;

import dmz.comercial.servicio.cliente.dto.RespuestaGenerarGuiaWs;
import dmz.comercial.servicio.cliente.dto.RespuestaGenerarPdfWs;
import dmz.comercial.servicio.cliente.dto.RespuestaTrackGuiaWs;

public class GuideBeanDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -904292667842883112L;
	private Guide guide;
	private Double deliveryCost;
	private Double deliveryPayment;
	private Double itemValue;
	private String pdfUrl;
	private String pdfTagUrl;
	private String pdfRotuleUrl;
	private RespuestaGenerarGuiaWs guideResponse;
	private RespuestaGenerarPdfWs  guidePdfResponse;
	private RespuestaTrackGuiaWs guideTrackResponse;
	private List<String> errorList;
	private String guideDeliveryId;
	private Supplier supplier;
	private List<ItemComplete> itemList;
	private String response;
	private List<GuideDetail> details;
	private Boolean hasPayment;
	private Double totalValue;
	private String guideNumber;
	private String deliveryName;
	
	public GuideBeanDTO(){
		errorList = new ArrayList<String>();
		itemList = new ArrayList<ItemComplete>();
		details = new ArrayList<GuideDetail>();
		hasPayment = Boolean.FALSE;
		totalValue = 0D;
	}
	
	public Guide getGuide() {
		return guide;
	}
	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	public Double getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public Double getDeliveryPayment() {
		return deliveryPayment;
	}
	public void setDeliveryPayment(Double deliveryPayment) {
		this.deliveryPayment = deliveryPayment;
	}
	public Double getItemValue() {
		return itemValue;
	}
	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public RespuestaGenerarGuiaWs getGuideResponse() {
		return guideResponse;
	}
	public void setGuideResponse(RespuestaGenerarGuiaWs guideResponse) {
		this.guideResponse = guideResponse;
	}
	public RespuestaGenerarPdfWs getGuidePdfResponse() {
		return guidePdfResponse;
	}
	public void setGuidePdfResponse(RespuestaGenerarPdfWs guidePdfResponse) {
		this.guidePdfResponse = guidePdfResponse;
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
	public String getGuideDeliveryId() {
		return guideDeliveryId;
	}
	public void setGuideDeliveryId(String guideDeliveryId) {
		this.guideDeliveryId = guideDeliveryId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<ItemComplete> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemComplete> itemList) {
		this.itemList = itemList;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<GuideDetail> getDetails() {
		return details;
	}

	public void setDetails(List<GuideDetail> details) {
		this.details = details;
	}

	public String getPdfTagUrl() {
		return pdfTagUrl;
	}

	public void setPdfTagUrl(String pdfTagUrl) {
		this.pdfTagUrl = pdfTagUrl;
	}

	public Boolean getHasPayment() {
		return hasPayment;
	}

	public void setHasPayment(Boolean hasPayment) {
		this.hasPayment = hasPayment;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public String getPdfRotuleUrl() {
		return pdfRotuleUrl;
	}

	public void setPdfRotuleUrl(String pdfRotuleUrl) {
		this.pdfRotuleUrl = pdfRotuleUrl;
	}

	public String getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	
	
}
