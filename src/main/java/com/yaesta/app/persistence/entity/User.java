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

@Entity
@Table(name = "user",schema="yaesta")
public class User implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4266835338392931520L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "passowrd")
	private String password;
	
	@Column(name = "document")
	private String document;
	
	@JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog role;
	
	@Column(name = "vitex_id")
	private String vitexId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Catalog getRole() {
		return role;
	}

	public void setRole(Catalog role) {
		this.role = role;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	
	
}