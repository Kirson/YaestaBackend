package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"codigoDestino",
	"razonSocial",
	"nombreVia",
	"direccionEntrega",
	"ubicacionGeografica"
})

public class ClientWarehouseVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 8727007673182071461L;
	private String codigoDestino;
	private String razonSocial;
	private String nombreVia;
	private String direccionEntrega;
	private String ubicacionGeografica;
	
	public ClientWarehouseVO(){}

	public String getCodigoDestino() {
		return codigoDestino;
	}

	public void setCodigoDestino(String codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	
	
	
}
