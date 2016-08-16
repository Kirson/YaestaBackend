package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.repository.TramacoZoneRepository;

@Service
public class TramacoZoneService {

	@Autowired
	TramacoZoneRepository tramacoZoneRepository;
	
	public List<TramacoZone> getByProvincia(String provincia){
		return tramacoZoneRepository.findByProvincia(provincia);
	}
	
	public List<TramacoZone> getByCanton(String canton){
		return tramacoZoneRepository.findByCanton(canton);
	}
	
	public List<TramacoZone> getAll(){
		return tramacoZoneRepository.findAll();
	}
	
	public List<TramacoZone> getByProvinciaCanton(String provincia, String canton){
		return tramacoZoneRepository.findByProvinciaAndCanton(provincia, canton);
	}
	
	public TramacoZone getByProvinciaCantonParroquia(String provincia, String canton, String parroquia){
		List<TramacoZone> query = tramacoZoneRepository.findByProvinciaAndCanton(provincia, canton);
		if(query!=null && !query.isEmpty()){
			return query.get(0);
		}else{
			return null;
		}
	}
	
}
