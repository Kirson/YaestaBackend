package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Address;
import com.yaesta.app.persistence.entity.Supplier;

public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findBySupplier(Supplier supplier);
}
