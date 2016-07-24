package com.yaesta.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierDeliveryCalendar;
import com.yaesta.app.persistence.repository.SupplierDeliveryCalendarRepository;
import com.yaesta.app.persistence.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private SupplierDeliveryCalendarRepository supplierDeliveryCalendarRepository;
	
	@Transactional
	public Supplier save(Supplier entity, List<SupplierDeliveryCalendar> deliveryCalendar){
		supplierRepository.save(entity);
		
		if(deliveryCalendar!=null && !deliveryCalendar.isEmpty()){
			for(SupplierDeliveryCalendar sdc:deliveryCalendar){
				sdc.setSupplier(entity);
			}
			
			supplierDeliveryCalendarRepository.save(deliveryCalendar);
		}
		
		
		return entity;
	}
	
	public Supplier findByVitexId(String vitexId){
		return supplierRepository.findByVitexId(vitexId);
	}
	
	public Supplier findById(Long id){
		return supplierRepository.getOne(id);
	}
	
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
}
