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
@Table(name = "tramaco_proveedor",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TramacoSupplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1818790696345341459L;

	@Id
	@Column(name="proveedor")
	private String proveedor;
	
	@Column(name="persona_contacto")
	private String personaContacto;
	
	@Column(name="direccion_retiro")
	private String direccionRetiro;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="gestor_entrega")
	private String gestorEntrega;
	
	@Column(name="contactos_proveedor")
	private String contactosProveedor;
	
	@Column(name="horario_atencion")
	private String horarioAtencion;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getDireccionRetiro() {
		return direccionRetiro;
	}

	public void setDireccionRetiro(String direccionRetiro) {
		this.direccionRetiro = direccionRetiro;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getGestorEntrega() {
		return gestorEntrega;
	}

	public void setGestorEntrega(String gestorEntrega) {
		this.gestorEntrega = gestorEntrega;
	}

	public String getContactosProveedor() {
		return contactosProveedor;
	}

	public void setContactosProveedor(String contactosProveedor) {
		this.contactosProveedor = contactosProveedor;
	}

	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	

}
