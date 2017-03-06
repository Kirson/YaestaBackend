package com.yaesta.app.persistence.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;
import com.yaesta.app.persistence.vo.OrderUpdVO;
import com.yaesta.app.persistence.vo.WarehouseVO;
import com.yaesta.app.util.UtilDate;

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
	
	@RequestMapping(value = "/getItemsByRange/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItem>> getItemsByRange(@PathVariable("startDate") String startDate,@PathVariable("finishDate") String finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		Date dStart = UtilDate.fromStringToDate(startDate);
		Date dFinish = UtilDate.fromStringToDate(finishDate);
		
		dateRange.setStartDate(dStart);
		dateRange.setFinishDate(dFinish);
		List<OrderItem> found = orderService.findByDateRange(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItem>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItem>>(new ArrayList<OrderItem>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsByRangeDate/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItem>> getItemsByRangeDate(@PathVariable("startDate") Date startDate,@PathVariable("finishDate") Date finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		dateRange.setStartDate(startDate);
		dateRange.setFinishDate(finishDate);
		List<OrderItem> found = orderService.findByDateRange(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItem>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItem>>(new ArrayList<OrderItem>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsByRangeDateVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItemBeanVO>> getItemsByRangeDateVO(@PathVariable("startDate") Date startDate,@PathVariable("finishDate") Date finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		dateRange.setStartDate(startDate);
		dateRange.setFinishDate(finishDate);
		List<OrderItemBeanVO> found = orderService.findByDateRangeVO(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItemBeanVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItemBeanVO>>(new ArrayList<OrderItemBeanVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsByRangeDateStrVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderItemBeanVO>> getItemsByRangeDateStrVO(@PathVariable("startDate") String startDate,@PathVariable("finishDate") String finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date dStartDate = format.parse(startDate);
		Date dFinishDate = format.parse(finishDate);
		
		dateRange.setStartDate(dStartDate);
		dateRange.setFinishDate(dFinishDate);
		List<OrderItemBeanVO> found = orderService.findByDateRangeVO(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<OrderItemBeanVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<OrderItemBeanVO>>(new ArrayList<OrderItemBeanVO>(),HttpStatus.OK);
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
	
	@RequestMapping(value = "/getAllWarehouseVO", method = RequestMethod.GET)
	public ResponseEntity<List<WarehouseVO>> getAllItemsWarehouseVO(){
		List<WarehouseVO> found = orderService.getAllWarehouse();
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<WarehouseVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<WarehouseVO>>(new ArrayList<WarehouseVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsWarehouseByRangeDateVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<WarehouseVO>> getItemsWarehouseByRangeDateVO(@PathVariable("startDate") Date startDate,@PathVariable("finishDate") Date finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		dateRange.setStartDate(startDate);
		dateRange.setFinishDate(finishDate);
		List<WarehouseVO> found = orderService.findByDateRangeVOWarehouse(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<WarehouseVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<WarehouseVO>>(new ArrayList<WarehouseVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsWarehouseByGuideDate/{guideDate}", method = RequestMethod.GET)
	public ResponseEntity<List<WarehouseVO>> getItemsWarehouseByGuideDate(@PathVariable("guideDate") Date guideDate) throws ParseException{
		
		
		
		List<WarehouseVO> found = orderService.findByStrGuideDateIsWarehouse(guideDate, Boolean.TRUE);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<WarehouseVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<WarehouseVO>>(new ArrayList<WarehouseVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getItemsWarehouseByRangeDateStrVO/{startDate}/{finishDate}", method = RequestMethod.GET)
	public ResponseEntity<List<WarehouseVO>> getItemsWarehouseByRangeDateStrVO(@PathVariable("startDate") String startDate,@PathVariable("finishDate") String finishDate) throws ParseException{
		
		DateRangeVO dateRange = new DateRangeVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date dStartDate = format.parse(startDate);
		Date dFinishDate = format.parse(finishDate);
		
		dateRange.setStartDate(dStartDate);
		dateRange.setFinishDate(dFinishDate);
		
		List<WarehouseVO> found = orderService.findByDateRangeVOWarehouse(dateRange);
		
		if(found!=null && !found.isEmpty()){
			return new ResponseEntity<List<WarehouseVO>>(found,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<WarehouseVO>>(new ArrayList<WarehouseVO>(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getPendingOrders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getPendingOrders(){
		List<Order> found = orderService.getPendingOrders();
		
		return new ResponseEntity<List<Order>>(found,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPendingInvoiceOrders/{flag}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getPendingInvoiceOrders(@PathVariable("flag") String flag){
		List<Order> found = orderService.getPendingInvoiceOrders(flag);
		
		return new ResponseEntity<List<Order>>(found,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateOrdersWithInvoice", method = RequestMethod.GET)
	public ResponseEntity<OrderUpdVO> updateOrdersWithInvoice(){
		OrderUpdVO ouvo = orderService.updateOrdersWithInvoice();
		
		
		return new ResponseEntity<OrderUpdVO>(ouvo,HttpStatus.OK);
	}

}
