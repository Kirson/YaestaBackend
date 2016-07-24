package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.repository.CatalogRepository;

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
	
	
	public List<Catalog> findByParentNemonic(String nemonic){
		List<Catalog> result = new ArrayList<Catalog>();
		List<Catalog> parentList = catalogRepository.findByNemonic(nemonic);
		
		if(parentList!=null && !parentList.isEmpty()){
			 Catalog parent = parentList.get(0);
			 result = findByMainCatalog(parent);
		}
		
		return result;
	}
	
	
}
