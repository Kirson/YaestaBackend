package com.yaesta.app.util;

import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;

public class OrderItemUtil {

	
	public static OrderItemBeanVO fromOrderItemToOrderItemVO(OrderItem item){
		OrderItemBeanVO obj = new OrderItemBeanVO();
		obj.setCustomerAddress(item.getCustomerAddress());
		obj.setCustomerCanton(item.getCustomerCanton());
		obj.setCustomerDocument(item.getCustomerDocument());
		obj.setCustomerName(item.getCustomerName());
		obj.setCustomerPhone("'"+item.getCustomerPhone());
		obj.setCustomerState(item.getCustomerState());
		obj.setCustomerValue(item.getCustomerValue());
		obj.setOrderDate(item.getOrderDate().toString());
		obj.setDiscount(item.getDiscount());
		obj.setOrderSequence(item.getOrderSequence());
		obj.setPrice(item.getPrice());
		obj.setProductDescription(item.getProductDescription());
		obj.setProductKey("'"+item.getProductKey());
		obj.setQuantity(item.getQuantity());
		obj.setStatusDescription(item.getStatusDescription());
		obj.setSupplierName(item.getSupplierName());
		obj.setUnitPrice(item.getUnitPrice());
		obj.setValueReceivables(item.getValueReceivables());
		obj.setVitexId(item.getVitexId());
		obj.setWayToPay(item.getWayToPay());
		return obj;
	}
}
