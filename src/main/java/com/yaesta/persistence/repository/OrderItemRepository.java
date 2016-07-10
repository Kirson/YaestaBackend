package com.yaesta.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Order;
import com.yaesta.persistence.entity.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

	public OrderItem findByVitexId(String vitexId);
	public List<OrderItem> findByOrder(Order order);
}
