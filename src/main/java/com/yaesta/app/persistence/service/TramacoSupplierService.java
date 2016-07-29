package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.TramacoSupplier;
import com.yaesta.app.persistence.repository.TramacoSupplierRepository;

@Service
public class TramacoSupplierService {

	@Autowired
	TramacoSupplierRepository tramacoSupplierRepository;
	
	public List<TramacoSupplier> getAll(){
		return tramacoSupplierRepository.findAll();
	}
	
	public List<TramacoSupplier> getBySupplier(Supplier supplier){
		return tramacoSupplierRepository.findBySupplier(supplier);
	}
}
