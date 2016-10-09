package com.yaesta.app.util;

import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;
import com.yaesta.app.persistence.vo.WarehouseVO;

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
		obj.setDeliveryName(item.getDeliveryName());
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
		obj.setInvoiceNumber(item.getInvoiceNumber());
		obj.setGuideNumber(item.getGuideNumber());
		return obj;
	}
	
	public static WarehouseVO fromOrderItemToWarehouseVO(OrderItem orderItem){
		WarehouseVO obj = new WarehouseVO();
		obj.setCantidad(orderItem.getQuantity());
		//obj.setCliente(orderItem.getCustomerName());
		String codCliente = orderItem.getCustomerDocument();
		
		while(codCliente.length()<10){
			codCliente="0"+codCliente;
		}
		
		codCliente="COD"+codCliente;
		obj.setCodigoCliente(codCliente);
		obj.setPedido(orderItem.getOrderSequence());
		obj.setTransaccion("P1");
		
		String codProducto = orderItem.getProductKey().trim();
		
		if(codProducto.length()>13){
			codProducto = codProducto.substring(0, 13);
		}
		while(codProducto.length()<13){
			codProducto="0"+codProducto;
		}
		codProducto="FK"+codProducto;
		obj.setProducto(codProducto);
		//obj.setOrdenCompra(orderItem.getVitexId());
		obj.setNumeroDocumento(orderItem.getVitexId());
		
		String datePart[] = UtilDate.dateParts(orderItem.getOrderDate());
		String fecha = datePart[0]+datePart[1]+datePart[2];
		
		obj.setFecha(fecha);
		obj.setFechaEntrega(fecha);
		
		return obj;
	}
}
