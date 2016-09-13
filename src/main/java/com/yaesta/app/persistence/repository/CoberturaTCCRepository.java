package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.CoberturaTCC;

public interface CoberturaTCCRepository  extends JpaRepository<CoberturaTCC, String> {

	public List<CoberturaTCC> findByProvincia(String provincia);
	public List<CoberturaTCC> findByProvinciaAndCanton(String provincia, String canton);
	public List<CoberturaTCC> findByProvinciaAndCantonAndParroquia(String provincia, String canton, String parroquia);
	
}
