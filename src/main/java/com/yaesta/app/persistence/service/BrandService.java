package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Brand;
import com.yaesta.app.persistence.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public List<Brand> getBrands(){
		return brandRepository.findAll();
	}
	
	public Brand findByVitexId(String vitexId){
		return brandRepository.findByVitexId(vitexId);
	}
}
