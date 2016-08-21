package com.yaesta.integration.vitex.bean;

import java.io.Serializable;

import com.yaesta.integration.vitex.json.bean.InvoiceSchema;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

public class InvoiceSchemaBean implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4996273800265399503L;
	private OrderComplete orderComplete;
	private InvoiceSchema invoiceSchema;
	
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}
	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}
	public InvoiceSchema getInvoiceSchema() {
		return invoiceSchema;
	}
	public void setInvoiceSchema(InvoiceSchema invoiceSchema) {
		this.invoiceSchema = invoiceSchema;
	}
	
	
}
