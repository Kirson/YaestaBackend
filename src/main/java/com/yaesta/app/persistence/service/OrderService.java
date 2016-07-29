package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Client;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.repository.OrderItemRepository;
import com.yaesta.app.persistence.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<Order> findByClient(Client client){
		List<Order> result = new ArrayList<Order>();
		List<Order> founds = orderRepository.findByClient(client);
		
		if(founds!=null && !founds.isEmpty()){
			 for(Order o:founds){
				 List<OrderItem> oiList = orderItemRepository.findByOrder(o);
				 o.setItems(oiList);
				 result.add(o);
			 }
		}else{
			result = null;
		}
		
		return result;
	}
	
	public List<Order> findByStatus(String status){
		List<Order> result = new ArrayList<Order>();
		List<Order> founds = orderRepository.findByStatus(status);
		if(founds!=null && !founds.isEmpty()){
			 for(Order o:founds){
				 List<OrderItem> oiList = orderItemRepository.findByOrder(o);
				 o.setItems(oiList);
				 result.add(o);
			 }
		}else{
			result = null;
		}
		
		return result;
	}
	
	public Order findByVitexId(String vitexId){
		List<Order> founds = orderRepository.findByVitexId(vitexId);
		Order found = null;
		if(founds!=null && !founds.isEmpty()){
		   found=founds.get(0);
		   List<OrderItem> oiList = orderItemRepository.findByOrder(found);
		   found.setItems(oiList);
		}
		
		return found;
	}
	
	
	public Order findByVitexIdOld(String vitexId){
		Order found = orderRepository.findByVitexId(vitexId).get(0);
		
		if(found!=null){
			List<OrderItem> oiList = orderItemRepository.findByOrder(found);
		   found.setItems(oiList);
		}
		
		return found;
	}
	
	public Order saveOrder(Order order){
		orderRepository.save(order);
		return order;
	}
}