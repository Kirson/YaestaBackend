package com.yaesta.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.Catalog;
import com.yaesta.persistence.repository.CatalogRepository;

@Service
public class CatalogService {

	@Autowired
	private CatalogRepository catalogRepository;
	
	public List<Catalog> getAll(){
		return catalogRepository.findAll();
	}
	
	public List<Catalog> getMainCatalogs(){
		return catalogRepository.findByMainCatalogIsNull();
	}
	
	
	public List<Catalog> findByMainCatalog(Catalog mainCatalog){
		return catalogRepository.findByMainCatalog(mainCatalog);
	}
	
	public Catalog findByVitexId(String vitextId){
		return catalogRepository.findByVitexId(vitextId);
	}
	
	
}
