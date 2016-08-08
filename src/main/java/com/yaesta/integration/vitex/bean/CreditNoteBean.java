package com.yaesta.integration.vitex.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditNoteBean implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3789772147274849757L;
	private OrderComplete orderComplete;
	private String documentNumber;
	private String motive;
	private String invoiceNumber;
	private String invoiceDate;
	private String fiscalPeriode;
	
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}
	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getMotive() {
		return motive;
	}
	public void setMotive(String motive) {
		this.motive = motive;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getFiscalPeriode() {
		return fiscalPeriode;
	}
	public void setFiscalPeriode(String fiscalPeriode) {
		this.fiscalPeriode = fiscalPeriode;
	}

	
	
}
