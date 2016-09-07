package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.repository.OrderItemRepository;
import com.yaesta.app.persistence.repository.OrderRepository;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;
import com.yaesta.app.persistence.vo.WarehouseVO;
import com.yaesta.app.util.OrderItemUtil;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<Order> findByClient(Customer client){
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
	
	public OrderItem saveOrderItem(OrderItem orderItem){
		orderItemRepository.save(orderItem);
		return orderItem;
	}
	
	public List<OrderItem> getAllItems(){
		List<OrderItem> found =orderItemRepository.findAll();
		return found;
	}
	
	public List<OrderItem> findByDateRange(DateRangeVO dateRange){
		List<OrderItem> found =orderItemRepository.findByOrderDateBetween(dateRange.getStartDate(), dateRange.getFinishDate());
		return found;
	}
	
	public List<OrderItemBeanVO> findByDateRangeVO(DateRangeVO dateRange){
		List<OrderItem> found =orderItemRepository.findByOrderDateBetween(dateRange.getStartDate(), dateRange.getFinishDate());
		List<OrderItemBeanVO> resultList = new ArrayList<OrderItemBeanVO>();
		if(found!=null && !found.isEmpty()){
			for(OrderItem oi:found){
				OrderItemBeanVO oiv = OrderItemUtil.fromOrderItemToOrderItemVO(oi);
				resultList.add(oiv);
			}
		}
		return resultList;
	}
	
	public List<OrderItemBeanVO> getAllItemsBean(){
		List<OrderItem> found =orderItemRepository.findAll();
		List<OrderItemBeanVO> resultList = new ArrayList<OrderItemBeanVO>();
		if(found!=null && !found.isEmpty()){
			for(OrderItem oi:found){
				OrderItemBeanVO oiv = OrderItemUtil.fromOrderItemToOrderItemVO(oi);
				resultList.add(oiv);
			}
		}
		
		return resultList;
	}
	
	public List<Order> getAll(){
		List<Order> found = orderRepository.findAll();
		return found;
	}
	
	public List<WarehouseVO> getAllWarehouse(){
		List<OrderItem> found = orderItemRepository.findByIsWarehouse(Boolean.TRUE);
		List<WarehouseVO> result = new ArrayList<WarehouseVO>();
		if(found!=null && !found.isEmpty()){
			for(OrderItem oi:found){
				WarehouseVO wvo = OrderItemUtil.fromOrderItemToWarehouseVO(oi);
				result.add(wvo);
			}
		}
		
		return result;
	}
	
	public List<WarehouseVO> findByDateRangeVOWarehouse(DateRangeVO dateRange){
		List<OrderItem> found =orderItemRepository.findByOrderDateBetweenAndByIsWarehouse(dateRange.getStartDate(), dateRange.getFinishDate(), Boolean.TRUE);
		List<WarehouseVO> resultList = new ArrayList<WarehouseVO>();
		if(found!=null && !found.isEmpty()){
			for(OrderItem oi:found){
				WarehouseVO oiv = OrderItemUtil.fromOrderItemToWarehouseVO(oi);
				resultList.add(oiv);
			}
		}
		return resultList;
	}
}
