package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.entity.Supplier;


public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findBySku(String sku);
	public Product findByName(String name);
	public Product findByVitexId(String vitexId);
	public List<Product> findByMainProduct(Product mainProduct);
	public List<Product> findBySupplier(Supplier supplier);
}
