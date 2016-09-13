package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.CoberturaTCC;
import com.yaesta.app.persistence.repository.CoberturaTCCRepository;

@Service
public class CoberturaTCCService {

	@Autowired
	CoberturaTCCRepository coberturaTCCRepository;
	
	public CoberturaTCC findByCodigo(String codigo){
		return coberturaTCCRepository.getOne(codigo);
	}
	
	public List<CoberturaTCC> findByProvincia(String provincia){
		List<CoberturaTCC> found = new ArrayList<CoberturaTCC>();
		
		found = coberturaTCCRepository.findByProvincia(provincia.trim().toUpperCase());
		
		return found;
	}
	
	public List<CoberturaTCC> findByProvinciaCanton(String provincia, String canton){
		List<CoberturaTCC> found = new ArrayList<CoberturaTCC>();
		
		found = coberturaTCCRepository.findByProvinciaAndCanton(provincia.trim().toUpperCase(),canton.trim().toUpperCase());
		
		return found;
	}
	
	public List<CoberturaTCC> findByProvinciaCantonParroquia(String provincia, String canton, String parroquia){
		List<CoberturaTCC> found = new ArrayList<CoberturaTCC>();
		
		found = coberturaTCCRepository.findByProvinciaAndCantonAndParroquia(provincia.trim().toUpperCase(),canton.trim().toUpperCase(),parroquia.trim().toUpperCase());
		
		return found;
	}
}
