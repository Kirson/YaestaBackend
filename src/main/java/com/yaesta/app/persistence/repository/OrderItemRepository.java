package com.yaesta.app.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

	public OrderItem findByVitexId(String vitexId);
	public List<OrderItem> findByOrder(Order order);
	
	@Query("Select oi from OrderItem oi " +
	         "where oi.orderDate between ?1 and ?2")
	public List<OrderItem> findByOrderDateBetween(Date start, Date finish);
	
	@Query("Select oi from OrderItem oi " +
	         "where oi.orderDate between ?1 and ?2 and oi.isWarehouse = ?3")
	public List<OrderItem> findByOrderDateBetweenAndByIsWarehouse(Date start, Date finish, Boolean isWarehouse);
	
	public List<OrderItem> findByIsWarehouse(Boolean isWarehouse);
}
