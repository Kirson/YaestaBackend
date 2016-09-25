package com.yaesta.app.pdf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GuideDataBean implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1475867026454000721L;
	private String guideNumber;
	private String orderId;
	private String pdfPath;
	private String logoPath;
	private List<String> paragraphs;
	private List<ItemData> itemDataList;
	private String resultMessage;
	private String creator;
	private String author;
	private String title;
	private String dataTitle;
	
	public GuideDataBean(){
		paragraphs = new ArrayList<String>();
		itemDataList = new ArrayList<ItemData>();
		author = "Yaesta.com";
		creator = "Yaesta.com";
		title = "Guia de Remision";
		dataTitle = "Detalle de items";
	}

	public String getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public List<String> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public List<ItemData> getItemDataList() {
		return itemDataList;
	}

	public void setItemDataList(List<ItemData> itemDataList) {
		this.itemDataList = itemDataList;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataTitle() {
		return dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	
	
}
