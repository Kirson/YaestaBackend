package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;

public interface GuideDetailRepository extends JpaRepository<GuideDetail, Long>{

	public List<GuideDetail> findByGuide(Guide guide);
	public GuideDetail findByVitexId(String vitexId);
}
