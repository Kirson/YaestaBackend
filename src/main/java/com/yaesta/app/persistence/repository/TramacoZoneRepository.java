package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.TramacoZone;

public interface TramacoZoneRepository extends JpaRepository<TramacoZone, Long> {

	
	public List<TramacoZone> findByParroquia(String parroquia);
	public List<TramacoZone> findByCanton(String canton);
	public List<TramacoZone> findByProvincia(String provincia);
	public List<TramacoZone> findByProvinciaAndCanton(String provincia,String canton);
	public List<TramacoZone> findByProvinciaAndCantonAndParroquia(String provincia,String canton, String parroquia);
}
