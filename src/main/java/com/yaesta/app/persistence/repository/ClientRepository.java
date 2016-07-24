package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	public Client findByVitexId(String vitexId);
	public Client findByDocument(String document);

}
