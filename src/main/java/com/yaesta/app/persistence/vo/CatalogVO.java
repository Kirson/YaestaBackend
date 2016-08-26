package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Catalog;

public class CatalogVO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private Catalog catalog;
	private List<Catalog> detailList;
	private List<Catalog> removeList;
	
	public CatalogVO(){
	   detailList = new ArrayList<Catalog>();	
	   removeList = new ArrayList<Catalog>();
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Catalog> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Catalog> detailList) {
		this.detailList = detailList;
	}

	public List<Catalog> getRemoveList() {
		return removeList;
	}

	public void setRemoveList(List<Catalog> removeList) {
		this.removeList = removeList;
	}
	
	
}
