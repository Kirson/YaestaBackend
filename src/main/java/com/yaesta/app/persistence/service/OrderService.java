package com.yaesta.app.persistence.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.GuideRepository;
import com.yaesta.app.persistence.repository.OrderItemRepository;
import com.yaesta.app.persistence.repository.OrderRepository;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.GfkVO;
import com.yaesta.app.persistence.vo.OrderItemBeanVO;
import com.yaesta.app.persistence.vo.OrderUpdVO;
import com.yaesta.app.persistence.vo.WarehouseVO;
import com.yaesta.app.util.OrderItemUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.datil.json.bean.FacturaConsulta;
import com.yaesta.integration.datil.service.DatilService;

@Service
public class OrderService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8804316300696055068L;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private GuideRepository guideRepository;

	@Autowired
	private YaEstaLogService logService;

	@Autowired
	private DatilService datilService;

	public List<Order> findByClient(Customer client) {
		List<Order> result = new ArrayList<Order>();
		List<Order> founds = orderRepository.findByClient(client);

		if (founds != null && !founds.isEmpty()) {
			for (Order o : founds) {
				List<OrderItem> oiList = orderItemRepository.findByOrder(o);
				o.setItems(oiList);
				result.add(o);
			}
		} else {
			result = null;
		}

		return result;
	}

	public List<Order> findByStatus(String status) {
		List<Order> result = new ArrayList<Order>();
		List<Order> founds = orderRepository.findByStatus(status);
		if (founds != null && !founds.isEmpty()) {
			for (Order o : founds) {
				List<OrderItem> oiList = orderItemRepository.findByOrder(o);
				o.setItems(oiList);
				result.add(o);
			}
		} else {
			result = null;
		}

		return result;
	}

	public Order findByVitexId(String vitexId) {
		List<Order> founds = orderRepository.findByVitexId(vitexId);
		Order found = null;
		if (founds != null && !founds.isEmpty()) {
			found = founds.get(0);
			List<OrderItem> oiList = orderItemRepository.findByOrder(found);
			found.setItems(oiList);
		}

		return found;
	}

	public Order findByVitexIdOld(String vitexId) {
		Order found = orderRepository.findByVitexId(vitexId).get(0);

		if (found != null) {
			List<OrderItem> oiList = orderItemRepository.findByOrder(found);
			found.setItems(oiList);
		}

		return found;
	}

	@Transactional
	public Order saveOrder(Order order) {
		orderRepository.save(order);
		try {
			List<OrderItem> oItems = orderItemRepository.findByOrder(order);

			if (oItems != null && !oItems.isEmpty()) {
				for (OrderItem oi : oItems) {
					oi.setDeliveryName(order.getDeliveryName());
					oi.setInvoiceReference(order.getInvoiceReference());
					oi.setInvoiceNumber(order.getInvoiceNumber());
					orderItemRepository.save(oi);
				}
			}

			List<Guide> guides = guideRepository.findByOrder(order);

			if (guides != null && !guides.isEmpty()) {
				for (Guide g : guides) {
					for (OrderItem oi : oItems) {
						if (g.getSupplier() != null && oi.getSupplier() != null
								&& g.getSupplier().getId().compareTo(oi.getSupplier().getId()) == 0) {
							oi.setGuideNumber(g.getGuideNumber());
							orderItemRepository.save(oi);
						}
					}
				}
			}
		} catch (Exception e) {

			YaEstaLog yaestaLog = new YaEstaLog();
			yaestaLog.setLogDate(new Date());
			yaestaLog.setProcessName("ORDER-UPDATE");
			yaestaLog.setOrderId(order.getVitexId());
			yaestaLog.setTextinfo("Error actualizando orden " + e.getMessage());
			logService.save(yaestaLog);
		}
		return order;
	}

	public OrderItem saveOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
		return orderItem;
	}

	public List<OrderItem> getAllItems() {
		List<OrderItem> found = orderItemRepository.findAll();
		return found;
	}

	public List<OrderItem> findByDateRange(DateRangeVO dateRange) {
		List<OrderItem> found = orderItemRepository.findByOrderDateBetween(dateRange.getStartDate(),
				dateRange.getFinishDate());
		return found;
	}

	public List<OrderItemBeanVO> findByDateRangeVO(DateRangeVO dateRange) {
		List<OrderItem> found = orderItemRepository.findByOrderDateBetween(dateRange.getStartDate(),
				dateRange.getFinishDate());
		List<OrderItemBeanVO> resultList = new ArrayList<OrderItemBeanVO>();
		if (found != null && !found.isEmpty()) {
			for (OrderItem oi : found) {
				OrderItemBeanVO oiv = OrderItemUtil.fromOrderItemToOrderItemVO(oi);
				resultList.add(oiv);
			}
		}
		return resultList;
	}

	public List<OrderItemBeanVO> getAllItemsBean() {
		List<OrderItem> found = orderItemRepository.findAll();
		List<OrderItemBeanVO> resultList = new ArrayList<OrderItemBeanVO>();
		if (found != null && !found.isEmpty()) {
			for (OrderItem oi : found) {
				OrderItemBeanVO oiv = OrderItemUtil.fromOrderItemToOrderItemVO(oi);
				resultList.add(oiv);
			}
		}

		return resultList;
	}

	public List<Order> getAll() {
		List<Order> found = orderRepository.findAll();
		return found;
	}

	public List<WarehouseVO> getAllWarehouse() {
		List<OrderItem> found = orderItemRepository.findByIsWarehouse(Boolean.TRUE);
		List<WarehouseVO> result = new ArrayList<WarehouseVO>();
		if (found != null && !found.isEmpty()) {
			for (OrderItem oi : found) {
				WarehouseVO wvo = OrderItemUtil.fromOrderItemToWarehouseVO(oi);
				result.add(wvo);
			}
		}

		return result;
	}

	public List<WarehouseVO> findByDateRangeVOWarehouse(DateRangeVO dateRange) {
		List<OrderItem> found = orderItemRepository.findByOrderDateBetweenAndByIsWarehouse(dateRange.getStartDate(),
				dateRange.getFinishDate(), Boolean.TRUE);
		List<WarehouseVO> resultList = new ArrayList<WarehouseVO>();
		if (found != null && !found.isEmpty()) {
			for (OrderItem oi : found) {
				WarehouseVO oiv = OrderItemUtil.fromOrderItemToWarehouseVO(oi);
				resultList.add(oiv);
			}
		}
		return resultList;
	}

	public List<WarehouseVO> findByStrGuideDateIsWarehouse(Date guideDate, Boolean isWarehouse) {
		List<OrderItem> found = orderItemRepository
				.findByStrGuideDateIsWarehouse(UtilDate.fromDateToString(guideDate, "yyyy-MM-dd"), isWarehouse);
		List<WarehouseVO> resultList = new ArrayList<WarehouseVO>();
		if (found != null && !found.isEmpty()) {
			for (OrderItem oi : found) {
				WarehouseVO oiv = OrderItemUtil.fromOrderItemToWarehouseVO(oi);
				resultList.add(oiv);
			}
		}
		return resultList;
	}

	public List<Order> getPendingOrders() {
		List<Order> found = orderRepository.findByPending(Boolean.TRUE);

		return found;
	}

	public List<Order> getPendingInvoiceOrders(String flag) {

		List<Order> found = new ArrayList<Order>();
		if (flag.equals("S")) {
			found = orderRepository.findByPendingInvoice(Boolean.TRUE);
		} else {
			found = orderRepository.findByPendingInvoice(Boolean.FALSE);
		}
		return found;
	}

	public List<GfkVO> buildGfk(String periode) {
		List<GfkVO> result = new ArrayList<GfkVO>();

		return result;

	}

	public List<OrderItem> getOrderItems(Order order) {
		List<OrderItem> items = orderItemRepository.findByOrder(order);
		return items;
	}

	public void updateOrderItem(OrderItem item) {
		orderItemRepository.save(item);
	}

	@Transactional
	public OrderUpdVO updateOrdersWithInvoice() {
		OrderUpdVO ouvo = new OrderUpdVO();
		ouvo.setMessage("OK");
		try {
			List<Order> orders = this.getAll();
			Long count = 0L;
			if (orders != null && !orders.isEmpty()) {
				for (Order order : orders) {
					count++;
					ouvo.setCount(count);
					if (order.getInvoiceReference() != null) {
						FacturaConsulta fc = datilService.findInvoice(order.getInvoiceReference());
						if (fc != null) {
							order.setInvoiceNumber(datilService.formatInvoiceNumber(fc.getSecuencial()));
							order.setSriAut(fc.getAutorizacion().getNumero());
							orderRepository.save(order);

							List<OrderItem> oiList = orderItemRepository.findByOrder(order);

							if (oiList != null && !oiList.isEmpty()) {
								for (OrderItem oi : oiList) {
									oi.setInvoiceNumber(order.getInvoiceNumber());
									oi.setInvoiceReference(order.getInvoiceReference());
									oi.setSriAut(order.getSriAut());
									orderItemRepository.save(oi);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			ouvo.setMessage("ERROR:" + e.getMessage());
		}
		return ouvo;
	}
}
