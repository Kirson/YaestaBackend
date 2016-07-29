package com.yaesta.integration.vitex.json.bean;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "value",
    "isPercentual",
    "identifier"})
public class PriceTag implements Serializable {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private Double value;
	@JsonProperty("isPercentual")
	private Boolean isPercentual;
	@JsonProperty("identifier")
	private String identifier;
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("value")
	public Double getValue() {
		return value;
	}
	@JsonProperty("value")
	public void setValue(Double value) {
		this.value = value;
	}
	@JsonProperty("isPercentual")
	public Boolean getIsPercentual() {
		return isPercentual;
	}
	@JsonProperty("isPercentual")
	public void setIsPercentual(Boolean isPercentual) {
		this.isPercentual = isPercentual;
	}
	@JsonProperty("identifier")
	public String getIdentifier() {
		return identifier;
	}
	@JsonProperty("identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	
}
