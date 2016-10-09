package com.yaesta.integration.sellercenter.json.bean;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "estado",
    "msg"
})
public class UserResponseError implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -3577721063274451090L;
	
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("msg")
	private String msg;
	
	@JsonProperty("estado")
	public String getEstado() {
		return estado;
	}
	
	@JsonProperty("estado")
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@JsonProperty("msg")
	public String getMsg() {
		return msg;
	}
	
	@JsonProperty("msg")
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
