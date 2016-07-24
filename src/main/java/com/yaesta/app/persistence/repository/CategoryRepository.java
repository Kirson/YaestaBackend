package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByVitexId(String vitexId);
}
