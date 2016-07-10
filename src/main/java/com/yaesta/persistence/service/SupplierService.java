package com.yaesta.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.Supplier;
import com.yaesta.persistence.entity.SupplierDeliveryCalendar;
import com.yaesta.persistence.repository.SupplierDeliveryCalendarRepository;
import com.yaesta.persistence.repository.SupplierRepository;

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
	
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
}
