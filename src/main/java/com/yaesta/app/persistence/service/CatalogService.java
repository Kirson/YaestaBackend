package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.repository.CatalogRepository;
import com.yaesta.app.service.SystemOutService;

@Service
public class CatalogService {

	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	SystemOutService systemOut;
	
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
	
	
	public Catalog findById(Long id){
		return catalogRepository.findOne(id);
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
	/**
	 * 
	 * @param catalog
	 * @param details
	 * @param removeList
	 * @return
	 */
	@Transactional
	public Catalog save(Catalog catalog, List<Catalog>details, List<Catalog> removeList){
		
		
		if(removeList!=null && !removeList.isEmpty()){
			for(Catalog cm:removeList){
				catalogRepository.delete(cm);
			}
		}
		
		catalog = catalogRepository.save(catalog);
		
		
		if(details!=null && !details.isEmpty()){
			for(Catalog c:details){
				c.setMainCatalog(catalog);
				catalogRepository.save(c);
			}
		}
		
		return catalog;
	}
	
	public String removeCatalogDetail(Catalog detail){
		String result = "OK";
		
		try{
			if(detail!=null){
			    Catalog remove = catalogRepository.findOne(detail.getId());
			    if(remove!=null){
			    	catalogRepository.delete(remove);
			    }
			}
		}catch(Exception e){
			systemOut.println("Error eliminando detalle de catalogo");
			result="ERROR";
		}
		
		return result;
	}
	
	public Catalog findByNemonic(String nemonic){
		Catalog found = null;
		List<Catalog> list = catalogRepository.findByNemonic(nemonic);
		
		if(list!=null && !list.isEmpty()){
			found = list.get(0);
		}
		
		return found;
	}
	
}
