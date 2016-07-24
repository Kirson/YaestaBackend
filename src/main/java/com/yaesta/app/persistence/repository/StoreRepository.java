package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{

}
