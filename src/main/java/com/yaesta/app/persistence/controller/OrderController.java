package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAll(){
		List<Order> found = orderService.getAll();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<Order>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Order>>(new ArrayList<Order>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItem>> getAllItems(){
		List<OrderItem> found = orderService.getAllItems();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItem>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItem>>(new ArrayList<OrderItem>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getAllItemsVO", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItemBeanVO>> getAllItemsVO(){
		List<OrderItemBeanVO> found = orderService.getAllItemsBean();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItemBeanVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItemBeanVO>>(new ArrayList<OrderItemBeanVO>(),HttpStatus.OK);
		}
	}

}
