package com.yaesta.integration.vitex.json.bean;

import java.io.Serializable;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder(
		{ 	"orderId", 
			"receipt", 
			"date" 
		})
public class OrderCancel implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4365656110976307097L;
	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("receipt")
	private String receipt;
	@JsonProperty("date")
	private String date;

	/**
	 * 
	 * @return The orderId
	 */
	@JsonProperty("orderId")
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 *            The orderId
	 */
	@JsonProperty("orderId")
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 * @return The receipt
	 */
	@JsonProperty("receipt")
	public String getReceipt() {
		return receipt;
	}

	/**
	 * 
	 * @param receipt
	 *            The receipt
	 */
	@JsonProperty("receipt")
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	/**
	 * 
	 * @return The date
	 */
	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 *            The date
	 */
	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

}
