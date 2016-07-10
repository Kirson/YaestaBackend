package com.yaesta.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.Store;
import com.yaesta.persistence.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public List<Store> getStores(){
		return storeRepository.findAll();
	}
	
}
