package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "status",
    "dateTime",
    "delivery",
    "transport",
    "carrier",
    "user",
    "city",
    "description"
})
public class TrackingVO implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 8147121173655844504L;
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("dateTime")
	private String dateTime;
	@JsonProperty("delivery")
	private String delivery;
	@JsonProperty("transport")
	private String transport; //transporte
	@JsonProperty("carrier")
	private String carrier; //transportista
	@JsonProperty("user")
	private String user;
	@JsonProperty("city")
	private String city;
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonProperty("dateTime")
	public String getDateTime() {
		return dateTime;
	}
	@JsonProperty("dateTime")
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@JsonProperty("delivery")
	public String getDelivery() {
		return delivery;
	}
	@JsonProperty("delivery")
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	@JsonProperty("transport")
	public String getTransport() {
		return transport;
	}
	@JsonProperty("transport")
	public void setTransport(String transport) {
		this.transport = transport;
	}
	@JsonProperty("carrier")
	public String getCarrier() {
		return carrier;
	}
	@JsonProperty("carrier")
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	@JsonProperty("user")
	public String getUser() {
		return user;
	}
	@JsonProperty("user")
	public void setUser(String user) {
		this.user = user;
	}
	@JsonProperty("city")
	public String getCity() {
		return city;
	}
	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
