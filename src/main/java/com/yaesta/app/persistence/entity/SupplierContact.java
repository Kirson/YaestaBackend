package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "supplier_contact",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SupplierContact implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4505763694357162649L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_contact_id_seq")
	@SequenceGenerator(name = "supplier_contact_id_seq", sequenceName = "supplier_contact_id_seq")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="ext")
	private String ext;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
