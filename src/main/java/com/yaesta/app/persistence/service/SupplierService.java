package com.yaesta.app.persistence.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.util.Constants;
import com.yaesta.app.persistence.entity.Address;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.entity.SupplierDeliveryCalendar;
import com.yaesta.app.persistence.entity.TramacoSupplier;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.repository.AddressRepository;
import com.yaesta.app.persistence.repository.SupplierContactRepository;
import com.yaesta.app.persistence.repository.SupplierDeliveryCalendarRepository;
import com.yaesta.app.persistence.repository.SupplierRepository;
import com.yaesta.app.persistence.repository.TramacoSupplierRepository;
import com.yaesta.app.persistence.repository.TramacoZoneRepository;


@Service
public class SupplierService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4542692183723268416L;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private SupplierContactRepository supplierContactRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private SupplierDeliveryCalendarRepository supplierDeliveryCalendarRepository;
	
	@Autowired
	private TramacoSupplierRepository tramacoSupplierRepository;
	
	@Autowired
	private TramacoZoneRepository tramacoZoneRepository;
	
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
	
	@Transactional
	public String updateSupplierFromAddress(){
		
		String response = "OK";
		
		try{
		List<Supplier> allSuppliers = supplierRepository.findAll();
		
		if(allSuppliers!=null && !allSuppliers.isEmpty()){
			for(Supplier supplier:allSuppliers){
				List<Address> addressList = addressRepository.findBySupplier(supplier);
				if(addressList!=null && !addressList.isEmpty()){
					
					for(Address address:addressList){
						Boolean update = false;
						if(supplier.getContactEmail()==null && address.getEmail()!=null){
							supplier.setContactEmail(address.getEmail());
							update = true;
						}
						//if(supplier.getContactDocument()==null && address.getDni()!=null)
						if(address.getDni()!=null){
							supplier.setContactDocument(address.getDni());
							update = true;
						}
						//if(supplier.getContactName()==null && address.getFirstname()!=null && !address.getFirstname().equals(Constants.supplierFlag))
						if(address.getFirstname()!=null && !address.getFirstname().equals(Constants.supplierFlag)){
							supplier.setContactName(address.getFirstname());
							update = true;
						}
						//if(supplier.getContactLastName()==null && address.getLastname()!=null && !address.getLastname().equals(Constants.supplierFlag))
						if(address.getLastname()!=null && !address.getLastname().equals(Constants.supplierFlag)){
							supplier.setContactLastName(address.getLastname());
							update = true;
						}
						//if(supplier.getName()==null && address.getAlias()!=null && !address.getAlias().equals(Constants.supplierFlag))
						if(address.getAlias()!=null && !address.getAlias().equals(Constants.supplierFlag)){
							supplier.setName(address.getAlias());
							update = true;
						}
						if(supplier.getStreetMain()==null && address.getAddress1()!=null){
							supplier.setStreetMain(address.getAddress1());
							update = true;
						}
						if(supplier.getStreetSecundary()==null && address.getAddress2()!=null){
							supplier.setStreetSecundary(address.getAddress2());
							update=true;
						}
						
						if(update){
							supplierRepository.saveAndFlush(supplier);
						}
					}//fin for address
				
				}//fin if address
					
				
				List<TramacoSupplier> tramacoSupplierList = tramacoSupplierRepository.findAll();
				
				if(tramacoSupplierList!=null && !tramacoSupplierList.isEmpty()){
					for(TramacoSupplier tramacoSupplier:tramacoSupplierList){
						
						if(tramacoSupplier.getProveedor().trim().toUpperCase().equals(supplier.getName().trim().toUpperCase())){
							tramacoSupplier.setSupplier(supplier);
							tramacoSupplierRepository.saveAndFlush(tramacoSupplier);
							
							List<TramacoZone> zones = tramacoZoneRepository.findByProvinciaAndCanton(tramacoSupplier.getProvincia(), tramacoSupplier.getGestorEntrega());
							if(zones!=null && !zones.isEmpty()){
								supplier.setPostalCode(zones.get(0).getCodigo()+"");
							}
							//completar informacion en proveedores
							String personContacts =  tramacoSupplier.getPersonaContacto();
							
							String[] persons = personContacts.split("%");
						
							if(persons!=null){
								int size = persons.length;
								for(int i=0;i<size;i++){
									SupplierContact sc = new SupplierContact();
									sc.setName(persons[i]);
									sc.setSupplier(supplier);
									supplierContactRepository.saveAndFlush(sc);
								}
								
								supplier.setContactName(persons[0]);
								supplier.setContactLastName(persons[0]);
							}
							else{
							   supplier.setContactName(personContacts);
							   supplier.setContactLastName(personContacts);
							}
							
							String contactInfo = tramacoSupplier.getContactosProveedor();
							
							String[] contacts = contactInfo.split("%");
							
							if(contacts!=null){
								int siz = contacts.length;
								for(int i=0;i<siz;i++){
									SupplierContact sc = new SupplierContact();
									sc.setSupplier(supplier);
									if(contacts[i].contains("@")){
										sc.setEmail(contacts[i].trim());
									}else if(contacts[i].trim().toUpperCase().contains("EXT")){
										String[] exts = contacts[i].split("EXT");
										sc.setPhone(exts[0]);
										sc.setExt(exts[1]);
									}
									supplierContactRepository.saveAndFlush(sc);
								}
							}
							
							supplierRepository.saveAndFlush(supplier);
						}
						
					}// fin for tramaco SupplierList
				}//fin if de tramacoSupplierList
				
			}// fin for de suppliers
		}
		}catch(Exception e){
			response = "Error:"+e.getMessage();
		}
		return response;
	}
}
