package com.yaesta.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.persistence.entity.Client;
import com.yaesta.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public Order findByVitexId(String vitexId);
	public List<Order> findByStatus(String status);
	public List<Order> findByClient(Client client);
}
