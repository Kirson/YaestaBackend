package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.yaesta.app.persistence.entity.GuideMigrate;

public interface GuideMigrateRepository extends JpaRepository<GuideMigrate, Long> {

	
}
