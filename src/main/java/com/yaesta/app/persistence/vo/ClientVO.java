package com.yaesta.app.persistence.vo;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"id",
	"document",
	"firstName",
	"lastName",
	"phone",
	"email",
	"province",
	"canton",
	"address",
	"lastPaymentMethod",
	"postalCode"
})
public class ClientVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1421605428134335807L;
	private Long id;
	private String document;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String province;
	private String canton;
	private String address;
	private String lastPaymentMethod;
	private String postalCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getLastPaymentMethod() {
		return lastPaymentMethod;
	}
	public void setLastPaymentMethod(String lastPaymentMethod) {
		this.lastPaymentMethod = lastPaymentMethod;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
