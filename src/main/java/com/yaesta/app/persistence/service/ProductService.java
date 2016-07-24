package com.yaesta.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public Product saveProduct(Product product, List<Product> skuList){
		productRepository.save(product);
		
		if(skuList!=null && !skuList.isEmpty()){
			for(Product sku:skuList){
				sku.setMainProduct(product);
				productRepository.save(sku);
			}
		}
		
		return product;
	}
	
	public Product findByVitexId(String vitexId){
		return productRepository.findByVitexId(vitexId);
	}
	
	public Product findBySku(String sku){
		return productRepository.findBySku(sku);
	}
	
	public List<Product> findBySupplier(Supplier supplier){
		return productRepository.findBySupplier(supplier);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
}
