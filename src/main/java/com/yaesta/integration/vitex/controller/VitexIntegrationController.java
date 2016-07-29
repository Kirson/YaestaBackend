package com.yaesta.integration.vitex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.service.DatilService;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.vitex.bean.GuideInfoBean;
import com.yaesta.integration.vitex.bean.OrderCompleteBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.OrderConversation;
import com.yaesta.integration.vitex.json.bean.OrderSchema;
import com.yaesta.integration.vitex.service.CategoryVitexService;
import com.yaesta.integration.vitex.service.OrderStatusVitexService;
import com.yaesta.integration.vitex.service.OrderVitexService;
import com.yaesta.integration.vitex.service.ProductVitexService;
import com.yaesta.integration.vitex.wsdl.dto.ArrayOfOrderDTO;
import com.yaesta.integration.vitex.wsdl.dto.OrderDTO;
import com.yaesta.integration.vitex.wsdl.dto.ProductDTO;
import com.yaesta.integration.vitex.wsdl.vo.OrderStatusVO;
import com.yaesta.integration.vitex.wsdl.vo.OrderVO;

import dmz.comercial.servicio.cliente.dto.EntityGuia;

@RestController
@RequestMapping(value = "/vitextIntegration")
public class VitexIntegrationController {

	@Autowired
	ProductVitexService productVitexService;
	
	@Autowired
	CategoryVitexService categoryVitexService;
	
	@Autowired
	OrderVitexService orderVitexService;
	
	@Autowired
	OrderStatusVitexService orderStatusVitexService;
	
	@Autowired
	DatilService datilService;
	
	@RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) {	  		 		
		System.out.println("==>>1<<===");
		
		ProductDTO product = productVitexService.findById(id);	
		System.out.println("==>>2<<===");
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/getOrdersNext50Vitex{sequence}", method = RequestMethod.GET)
	public ResponseEntity<ArrayOfOrderDTO> getOrdersNext50Vitex(@PathVariable("sequence") Integer sequence) {	  		 		
		ArrayOfOrderDTO resultList = orderVitexService.getOrders(sequence);
		return new ResponseEntity<ArrayOfOrderDTO>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrdersNext50{sequence}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderVO>> getOrdersNext50(@PathVariable("sequence") Integer sequence) {	  		 		
		List<OrderVO> resultList = orderVitexService.getOrdersNext50(sequence);
		return new ResponseEntity<List<OrderVO>>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findOrderById{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") Integer id) {	  		 		
		
		OrderDTO order = orderVitexService.findById(id);
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrderById{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") String id) {	  		 		
		//System.out.println("==>>1<<===");
		
		OrderDTO order = orderVitexService.findOrderById(id);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrder{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderVO> getOrder(@PathVariable("id") String id) {	  		 		
		
		OrderVO order = orderVitexService.findOrder(id);
		return new ResponseEntity<OrderVO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrderStatus", method = RequestMethod.GET)
	public ResponseEntity<List<OrderStatusVO>> getOrderStatus() {	  		 		
		
		List<OrderStatusVO> orderStatusList = orderStatusVitexService.getOrderStatusList();
		return new ResponseEntity<List<OrderStatusVO>>(orderStatusList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrdersRest", method = RequestMethod.GET)
	public ResponseEntity<OrderSchema> getOrdersRest() {	  		 		
		
		OrderSchema json = orderVitexService.getOrdersRest(null);
		return new ResponseEntity<OrderSchema>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrdersRestStatus{status}", method = RequestMethod.GET)
	public ResponseEntity<OrderSchema> getOrdersRestStatus(@PathVariable("status") String status) {	  		 		
		System.out.println("status::"+status);
		OrderSchema json = orderVitexService.getOrdersRest(status);
		return new ResponseEntity<OrderSchema>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrderComplete{orderId}", method = RequestMethod.GET)
	public ResponseEntity<OrderComplete> getOrderComplete(@PathVariable("orderId") String orderId) {	  		 		
		
		OrderComplete json = orderVitexService.getOrderComplete(orderId);
		return new ResponseEntity<OrderComplete>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrderConversation{orderId}", method = RequestMethod.GET)
	public ResponseEntity<OrderConversation> getOrderConversation(@PathVariable("orderId") String orderId) {	  		 		
		
		OrderConversation json = orderVitexService.getOrderConversation(orderId);
		return new ResponseEntity<OrderConversation>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public ResponseEntity<OrderComplete> changeStatus(@RequestBody OrderCompleteBean orderCompleteBean) {	  		 		
		
		OrderComplete json = orderVitexService.changeStatus(orderCompleteBean.getOrder(),orderCompleteBean.getAction());
		return new ResponseEntity<OrderComplete>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generateGuide", method = RequestMethod.POST)
	public ResponseEntity<GuideInfoBean> generateGuide(@RequestBody GuideInfoBean guideInfoBean){
		
		GuideInfoBean response = new GuideInfoBean();
		response = orderVitexService.generateGuides(guideInfoBean);
		
		
		for(GuideDTO guide:response.getGuides()){
			System.out.println("==>" + guide.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias().size());
		    for(EntityGuia eg:guide.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias()){
		    	response.getGuideIdList().add(eg.getId()+"%"+eg.getGuia());
		    }
		}
		
		
		return new ResponseEntity<GuideInfoBean>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/invoiceOrder", method = RequestMethod.POST)
	public ResponseEntity<FacturaRespuestaSRI> invoiceOrder(@RequestBody OrderCompleteBean orderCompleteBean) {	  		 		
		
		OrderComplete oc = orderCompleteBean.getOrder();
		FacturaRespuestaSRI response=datilService.processInvoiceOrder(oc);
		return new ResponseEntity<FacturaRespuestaSRI>(response, HttpStatus.OK);
	}
	
}
