package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;

public interface SupplierContactRepository extends JpaRepository<SupplierContact, Long>{

	public List<SupplierContact> findBySupplier(Supplier supplier);
}
