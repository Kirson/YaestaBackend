package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	@JsonBackReference(value="supplier-country")
	@JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog country;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="phone_list")
	private String phoneList;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="email_list")
	private String emailList;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="contact_list")
	private String contactList;
	
	@Column(name="province")
	private String province;
	
	@Column(name="canton")
	private String canton;
	
	@Column(name="delivery_manager")
	private String deliveryManager;
	
	@Column(name="office_hours")
	private String officeHours;
	
	@JoinColumn(name = "tramaco_zone", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.LAZY)
	private TramacoZone zone;
	
	@Column(name="found")
	private Boolean found;
	
	@JsonBackReference(value="supplier-category")
	@JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog category;
	
	@JsonBackReference(value="supplier-bank")
	@JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog bank;
	
	@JsonBackReference(value="supplier-accountType")
	@JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog accountType;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="account_email")
	private String accountEmail;
	
	@Column(name="is_new")
	private Boolean isNew;
	
	@JsonBackReference(value="supplier-productListStatus")
	@JoinColumn(name = "product_list_status_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog productListStatus;
	
	@JsonBackReference(value="supplier-status")
	@JoinColumn(name = "supplier_status_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog supplierStatus;
	
	@JsonBackReference(value="supplier-priority")
	@JoinColumn(name = "priority_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog priority;
	
	@JsonBackReference(value="supplier-supplierType")
	@JoinColumn(name = "supplier_type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog supplierType;
	
	@Column(name="is_warehouse")
	private Boolean isWarehouse;
	
	@Column(name = "seller_user")
	private String sellerUser;
	
	@Column(name = "tcc_code")
	private String tccCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "password")
	private String password;
	
	@Transient
	private String shippingAddress;
	
	public Supplier(){
		isNew = Boolean.TRUE;
		isWarehouse = Boolean.FALSE;
	}

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
	
	
	

	public String getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(String phoneList) {
		this.phoneList = phoneList;
	}

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public String getContactList() {
		return contactList;
	}

	public void setContactList(String contactList) {
		this.contactList = contactList;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getDeliveryManager() {
		return deliveryManager;
	}

	public void setDeliveryManager(String deliveryManager) {
		this.deliveryManager = deliveryManager;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public TramacoZone getZone() {
		return zone;
	}

	public void setZone(TramacoZone zone) {
		this.zone = zone;
	}
	
	

	public Boolean getFound() {
		return found;
	}

	public void setFound(Boolean found) {
		this.found = found;
	}
	
	

	public Catalog getCategory() {
		return category;
	}

	public void setCategory(Catalog category) {
		this.category = category;
	}

	public Catalog getBank() {
		return bank;
	}

	public void setBank(Catalog bank) {
		this.bank = bank;
	}

	public Catalog getAccountType() {
		return accountType;
	}

	public void setAccountType(Catalog accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
	
	

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	
	

	public Catalog getProductListStatus() {
		return productListStatus;
	}

	public void setProductListStatus(Catalog productListStatus) {
		this.productListStatus = productListStatus;
	}

	public Catalog getSupplierStatus() {
		return supplierStatus;
	}

	public void setSupplierStatus(Catalog supplierStatus) {
		this.supplierStatus = supplierStatus;
	}
	
	

	public Catalog getPriority() {
		return priority;
	}

	public void setPriority(Catalog priority) {
		this.priority = priority;
	}

	public Boolean getIsWarehouse() {
		return isWarehouse;
	}

	public void setIsWarehouse(Boolean isWarehouse) {
		this.isWarehouse = isWarehouse;
	}
	
	

	public Catalog getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(Catalog supplierType) {
		this.supplierType = supplierType;
	}
	
	

	public String getSellerUser() {
		return sellerUser;
	}

	public void setSellerUser(String sellerUser) {
		this.sellerUser = sellerUser;
	}
	
	

	public String getTccCode() {
		return tccCode;
	}

	public void setTccCode(String tccCode) {
		this.tccCode = tccCode;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
