package com.yaesta.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.YaEstaLog;


public interface YaEstaLogRepository extends JpaRepository<YaEstaLog, Long> {

}
