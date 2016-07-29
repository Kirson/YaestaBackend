package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "supplier",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4505763694357162649L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq_gen")
	@SequenceGenerator(name = "supplier_seq_gen", sequenceName = "supplier_id_seq")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "address_reference")
	private String addressReference;
	
	@Column(name = "street_main")
	private String streetMain;
	
	@Column(name = "street_secundary")
	private String streetSecundary;
	
	@Column(name = "street_number")
	private String streetNumber;
	
	@Column(name = "active")
	private Integer active;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_last_name")
	private String contactLastName;
	
	@Column(name = "contact_document")
	private String contactDocument;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "mobile_phone")
	private String mobilePhone;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name="date_add")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdd;
	
	@Column(name="date_upd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpd;
	
	@JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog country;
	
	@Transient
	private String shippingAddress;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public Date getDateUpd() {
		return dateUpd;
	}

	public void setDateUpd(Date dateUpd) {
		this.dateUpd = dateUpd;
	}

	public Catalog getCountry() {
		return country;
	}

	public void setCountry(Catalog country) {
		this.country = country;
	}
	
	

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getAddressReference() {
		return addressReference;
	}

	public void setAddressReference(String addressReference) {
		this.addressReference = addressReference;
	}

	public String getStreetMain() {
		return streetMain;
	}

	public void setStreetMain(String streetMain) {
		this.streetMain = streetMain;
	}

	public String getStreetSecundary() {
		return streetSecundary;
	}

	public void setStreetSecundary(String streetSecundary) {
		this.streetSecundary = streetSecundary;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactDocument() {
		return contactDocument;
	}

	public void setContactDocument(String contactDocument) {
		this.contactDocument = contactDocument;
	}
	
	

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

	public String getShippingAddress() {
		
		shippingAddress = "";
		
		if(this.getStreetMain()!=null){
			shippingAddress = shippingAddress+this.getStreetMain();
		}
		
		if(this.getStreetNumber()!=null){
			shippingAddress = shippingAddress+" "+getStreetNumber();
		}
		
		if(this.getStreetSecundary()!=null){
			shippingAddress = shippingAddress+" "+getStreetSecundary();
		}
		
		if(this.getStreetSecundary()!=null){
			shippingAddress = shippingAddress+" "+getStreetSecundary();
		}
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}