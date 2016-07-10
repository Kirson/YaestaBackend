package com.yaesta.tramaco.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import dmz.comercial.servicio.cliente.dto.EntityActor;

@XmlRootElement
public class ParticipantDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3930029662463330295L;
	private String type;
	private String email;
	private String firstName;
	private String lastName;
	private String mainStreet;
	private String secundaryStreet;
	private String homeNumber;
	private String addressReference;
	private String documentType;
	private String ciRuc;
	private String phone;
	private String postalCode;
	private EntityActor originalParticipant;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getMainStreet() {
		return mainStreet;
	}
	public void setMainStreet(String mainStreet) {
		this.mainStreet = mainStreet;
	}
	public String getSecundaryStreet() {
		return secundaryStreet;
	}
	public void setSecundaryStreet(String secundaryStreet) {
		this.secundaryStreet = secundaryStreet;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getAddressReference() {
		return addressReference;
	}
	public void setAddressReference(String addressReference) {
		this.addressReference = addressReference;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getCiRuc() {
		return ciRuc;
	}
	public void setCiRuc(String ciRuc) {
		this.ciRuc = ciRuc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public EntityActor getOriginalParticipant() {
		return originalParticipant;
	}
	public void setOriginalParticipant(EntityActor originalParticipant) {
		this.originalParticipant = originalParticipant;
	}
	
	

}
