package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Store;
import com.yaesta.app.persistence.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public List<Store> getStores(){
		return storeRepository.findAll();
	}
	
}
