package com.yaesta.integration.vitex.json.bean;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "date",
    "orderId",
    "receipt"
})
public class InvoiceResponse implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5357932058833339309L;
	@JsonProperty("date")
    private String date;
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("receipt")
    private String receipt;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
    
    
}
