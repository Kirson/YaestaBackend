package com.yaesta.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {

	public Parameter findByNemonic(String nemonic);
}
