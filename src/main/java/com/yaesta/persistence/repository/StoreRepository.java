package com.yaesta.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{

}
