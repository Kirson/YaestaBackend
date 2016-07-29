package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Address;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
	
	public List<Address> getBySupplier(Supplier supplier){
		return addressRepository.findBySupplier(supplier);
	}
	
}
