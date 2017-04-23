package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Customer;

public interface ClientRepository extends JpaRepository<Customer, Long> {
	
	public Customer findByVitexId(String vitexId);
	public List<Customer> findByDocument(String document);

}
