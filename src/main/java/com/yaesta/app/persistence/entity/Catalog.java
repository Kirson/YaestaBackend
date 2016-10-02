package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "catalog",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Catalog implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 563126279728989470L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq_gen")
	@SequenceGenerator(name = "catalog_seq_gen", sequenceName = "catalog_id_seq")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nemonic")
	private String nemonic;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@JsonBackReference
	@JoinColumn(name = "catalog_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog mainCatalog;
	
	@OneToMany(mappedBy = "mainCatalog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(nullable = true)
	@JsonManagedReference
	private List<Catalog> details;
	
	public Catalog(){
		details = new ArrayList<Catalog>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public Catalog getMainCatalog() {
		return mainCatalog;
	}

	public void setMainCatalog(Catalog mainCatalog) {
		this.mainCatalog = mainCatalog;
	}
	
	

	public String getNemonic() {
		return nemonic;
	}

	public void setNemonic(String nemonic) {
		this.nemonic = nemonic;
	}
	
	

	public List<Catalog> getDetails() {
		return details;
	}

	public void setDetails(List<Catalog> details) {
		this.details = details;
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
		Catalog other = (Catalog) obj;
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
