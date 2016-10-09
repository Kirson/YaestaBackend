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
    "msg",
    "usuario"
})
public class UserResponseContainer implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2981152291363883635L;
	
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("usuario")
	private UserResponseBean usuario;
	
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
	
	@JsonProperty("usuario")
	public UserResponseBean getUsuario() {
		return usuario;
	}
	
	@JsonProperty("usuario")
	public void setUsuario(UserResponseBean usuario) {
		this.usuario = usuario;
	}
	
	
}
