package com.yaesta.app.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.yaesta.app.persistence.entity.GuideProcess;

public interface GuideProcessRepository extends JpaRepository<GuideProcess, Long> {

	public List<GuideProcess> findByProcessDate(Date processDate); //corresponde a las fechas programadas de entrega
	public List<GuideProcess> findByClosedDate(Boolean closedDate);
}
