package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proveedor",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proveedor implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 6029948398755486307L;

	@Id
	@Column(name="nombre_proveedor")
	private String nombreProveedor;
	
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="persona_contacto")
	private String personaContacto;
	
	@Column(name="direccion_retiro")
	private String direccion;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="canton")
	private String canton;
	
	@Column(name="gestor_entrega")
	private String gestorEntrega;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="horario_atencion")
	private String horarioAtencion;
	
	@JoinColumn(name = "zona_tramaco", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.LAZY)
	private TramacoZone zona;

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getGestorEntrega() {
		return gestorEntrega;
	}

	public void setGestorEntrega(String gestorEntrega) {
		this.gestorEntrega = gestorEntrega;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public TramacoZone getZona() {
		return zona;
	}

	public void setZona(TramacoZone zona) {
		this.zona = zona;
	}
	
	
	
}
