package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente_bodega",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteBodega implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8636772916506729002L;

	@Id
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="nombre_via")
	private String nombreVia;
	
	@Column(name="direccion_entrega")
	private String direccionEntrega;
	
	@Column(name="ubicacion_geografica")
	private String ubicacionGeografia;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name="nuevo")
	private String nuevo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getUbicacionGeografia() {
		return ubicacionGeografia;
	}

	public void setUbicacionGeografia(String ubicacionGeografia) {
		this.ubicacionGeografia = ubicacionGeografia;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNuevo() {
		return nuevo;
	}

	public void setNuevo(String nuevo) {
		this.nuevo = nuevo;
	}
	
	
}
