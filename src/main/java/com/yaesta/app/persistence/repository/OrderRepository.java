package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByVitexId(String vitexId);
	public List<Order> findByStatus(String status);
	public List<Order> findByClient(Customer client);
	public List<Order> findByPending(Boolean pending);
}
