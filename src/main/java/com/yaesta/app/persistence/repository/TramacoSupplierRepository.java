package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.TramacoSupplier;

public interface TramacoSupplierRepository extends JpaRepository<TramacoSupplier, String>{

	public List<TramacoSupplier> findBySupplier(Supplier supplier);
	
	
}
