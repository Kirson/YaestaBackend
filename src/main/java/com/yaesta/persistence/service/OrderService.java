package com.yaesta.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.Client;
import com.yaesta.persistence.entity.Order;
import com.yaesta.persistence.entity.OrderItem;
import com.yaesta.persistence.repository.OrderItemRepository;
import com.yaesta.persistence.repository.OrderRepository;

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
		Order found = orderRepository.findByVitexId(vitexId);
		
		if(found!=null){
			List<OrderItem> oiList = orderItemRepository.findByOrder(found);
		   found.setItems(oiList);
		}
		
		return found;
	}
}
