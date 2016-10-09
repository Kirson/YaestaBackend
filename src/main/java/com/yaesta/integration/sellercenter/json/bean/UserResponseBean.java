package com.yaesta.integration.sellercenter.json.bean;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "idusuario",
    "id",
    "email",
    "usuario",
    "nombre",
    "password"
})
public class UserResponseBean implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 944368313929033388L;
	@JsonProperty("idusuario")
	private String idusuario;
	@JsonProperty("id")
	private String id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("usuario")
	private String usuario;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("idusuario")
	public String getIdusuario() {
		return idusuario;
	}
	
	@JsonProperty("idusuario")
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("usuario")
	public String getUsuario() {
		return usuario;
	}
	
	@JsonProperty("usuario")
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}
	
	@JsonProperty("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
