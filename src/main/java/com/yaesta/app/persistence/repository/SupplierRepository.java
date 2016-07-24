package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	public Supplier findByVitexId(String vitexId);
}
