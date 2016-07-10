package com.yaesta.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long>  {

	public Brand findByVitexId(String vitexId);
}
