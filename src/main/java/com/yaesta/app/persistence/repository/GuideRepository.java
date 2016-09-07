package com.yaesta.app.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.Order;

public interface GuideRepository extends JpaRepository<Guide, Long>{

	public Guide findByVitexId(String vitexId);
	public List<Guide> findByDeliveryName(String deliveryName);
	public List<Guide> findByStatus(String status);
	public List<Guide> findByOrder(Order order);
	@Query("Select gui from Guide gui " +
	         "where gui.createDate between ?1 and ?2")
	public List<Guide> findByCreateDateBetween(Date start, Date finish);
	
}
