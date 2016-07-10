package com.yaesta.vitex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.yaesta.app.util.UtilDate;
import com.yaesta.vitex.service.base.BaseVitexService;
import com.yaesta.vitex.vo.OrderDeliveryVO;
import com.yaesta.vitex.vo.OrderItemVO;
import com.yaesta.vitex.vo.OrderVO;
import com.yaesta.vitex.wsdl.OrderGet;
import com.yaesta.vitex.wsdl.OrderGetNext50FromIdV3;
import com.yaesta.vitex.wsdl.OrderGetNext50FromIdV3Response;
import com.yaesta.vitex.wsdl.OrderGetResponse;
import com.yaesta.vitex.wsdl.OrderGetV3;
import com.yaesta.vitex.wsdl.OrderGetV3Response;
import com.yaesta.vitex.wsdl.dto.ArrayOfOrderDTO;
import com.yaesta.vitex.wsdl.dto.OrderDTO;
import com.yaesta.vitex.wsdl.dto.OrderItemDTO;
import com.yaesta.vitex.wsdl.dto.ProductDTO;
import com.yaesta.vitex.wsdl.dto.OrderDeliveryDTO;

@Service
public class OrderVitexService  extends BaseVitexService {

	

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	@Autowired
	private ProductVitexService productVitexService;
	
	public OrderVitexService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ArrayOfOrderDTO getOrders(Integer sequence){
		
		OrderGetNext50FromIdV3 query = objectFactory.createOrderGetNext50FromIdV3();
		query.setSequence(sequence);
		//System.out.println("==>>A");
		OrderGetNext50FromIdV3Response response = (OrderGetNext50FromIdV3Response)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/OrderGetNext50FromIdV3"));
		//System.out.println("==>>B");
		return response.getOrderGetNext50FromIdV3Result().getValue();
		
	}
	
	
	public List<OrderVO> getOrdersNext50(Integer sequence){
		List<OrderVO> result = new ArrayList<OrderVO>();
		
		ArrayOfOrderDTO array = getOrders(sequence);
		
		if(array!=null){
			if(array.getOrderDTO()!=null && !array.getOrderDTO().isEmpty())
			{
				 for(OrderDTO odto:array.getOrderDTO()){
					 OrderVO ovo = new OrderVO();
					 ovo.setId(odto.getId().getValue().longValue());
					 ovo.setVitexId(odto.getId().getValue().longValue()+"");
					 ovo.setCity(odto.getAddress().getValue().getCity().getValue());
					 ovo.setCost(odto.getCost().getValue());
					 ovo.setStore(odto.getStoreName().getValue());
					 ovo.setCustomerVitexId(odto.getClientId().getValue()+"");
					 ovo.setCustomerFirstName(odto.getClient().getValue().getFirstName().getValue());
					 ovo.setCustomerLastName(odto.getClient().getValue().getLastName().getValue());
					 ovo.setPurchaseDate(UtilDate.toDate(odto.getPurchaseDate().getValue()));
					 if(odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()!=null && !odto.getOrderDeliveries().getValue().getOrderDeliveryDTO().isEmpty()){
						 for(OrderDeliveryDTO oddto:odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()){
							 OrderDeliveryVO odvo = new OrderDeliveryVO();
							 odvo.setFreightId(oddto.getFreightId().getValue()+"");
							 odvo.setFreightName(oddto.getFreightName().getValue());
							 odvo.setOrderStatusDescription(oddto.getOrderStatus().getValue().getDescription().getValue());
							 odvo.setOrderStatusCode(oddto.getOrderStatus().getValue().getId().getValue());
							 if(oddto.getDeliveryDate().getValue()!=null){
								 odvo.setDeliveryDate(UtilDate.toDate(oddto.getDeliveryDate().getValue()));
							 }
							 if(oddto.getOrderItems().getValue().getOrderItemDTO()!=null && !oddto.getOrderItems().getValue().getOrderItemDTO().isEmpty())
							 {
								 for(OrderItemDTO oidto:oddto.getOrderItems().getValue().getOrderItemDTO()){
									 OrderItemVO oivo = new OrderItemVO();
									 oivo.setCost(oidto.getCost().getValue());
									 
									 ProductDTO pdto = productVitexService.findById(oidto.getProductId().getValue());
									 
									 oivo.setProductRefId(oidto.getProductRefId().getValue());
									 oivo.setProductName(pdto.getName().getValue());
									 oivo.setProductId(oidto.getProductId().getValue()+"");
									 oivo.setProductVitexId(oidto.getProductId().getValue()+"");
									 oivo.setShippingCost(oidto.getShippingCost().getValue());
									 odvo.getItems().add(oivo);
									 
								 }
							 }
							 ovo.getDeliveries().add(odvo);
						 }
					 }
				 
					 result.add(ovo);
				 }
				 
				
			}
			
		}
		
		return result;
	}
	
	public OrderDTO findById(Integer orderId){
		OrderGet query = objectFactory.createOrderGet();
		query.setOrderId(orderId);
		//System.out.println("==>>A");
		OrderGetResponse response = (OrderGetResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/OrderGet"));
		//System.out.println("==>>B");
		return response.getOrderGetResult().getValue();
		
	}
	
	public OrderDTO findOrderById(String orderId){
		OrderGetV3 query = objectFactory.createOrderGetV3();
		query.setOrderId(objectFactory.createString(orderId));
		//System.out.println("==>>A");
		OrderGetV3Response response = (OrderGetV3Response)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/OrderGetV3"));
		//System.out.println("==>>B");
		return response.getOrderGetV3Result().getValue();	
	}
	
	public OrderVO findOrder(String orderId){
		OrderVO ovo = new OrderVO();
		OrderDTO odto = findOrderById(orderId);
		if(odto!=null){
			
			ovo.setId(odto.getId().getValue().longValue());
			 ovo.setVitexId(odto.getId().getValue().longValue()+"");
			 ovo.setCity(odto.getAddress().getValue().getCity().getValue());
			 ovo.setCost(odto.getCost().getValue());
			 ovo.setStore(odto.getStoreName().getValue());
			 ovo.setCustomerVitexId(odto.getClientId().getValue()+"");
			 ovo.setCustomerFirstName(odto.getClient().getValue().getFirstName().getValue());
			 ovo.setCustomerLastName(odto.getClient().getValue().getLastName().getValue());
			 ovo.setPurchaseDate(UtilDate.toDate(odto.getPurchaseDate().getValue()));
			 if(odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()!=null && !odto.getOrderDeliveries().getValue().getOrderDeliveryDTO().isEmpty()){
				 for(OrderDeliveryDTO oddto:odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()){
					 OrderDeliveryVO odvo = new OrderDeliveryVO();
					 odvo.setFreightId(oddto.getFreightId().getValue()+"");
					 odvo.setFreightName(oddto.getFreightName().getValue());
					 odvo.setOrderStatusDescription(oddto.getOrderStatus().getValue().getDescription().getValue());
					 odvo.setOrderStatusCode(oddto.getOrderStatus().getValue().getId().getValue());
					 if(oddto.getDeliveryDate().getValue()!=null){
						 odvo.setDeliveryDate(UtilDate.toDate(oddto.getDeliveryDate().getValue()));
					 }
					 if(oddto.getOrderItems().getValue().getOrderItemDTO()!=null && !oddto.getOrderItems().getValue().getOrderItemDTO().isEmpty())
					 {
						 for(OrderItemDTO oidto:oddto.getOrderItems().getValue().getOrderItemDTO()){
							 OrderItemVO oivo = new OrderItemVO();
							 oivo.setCost(oidto.getCost().getValue());
							 
							 ProductDTO pdto = productVitexService.findById(oidto.getProductId().getValue());
							 
							 oivo.setProductRefId(oidto.getProductRefId().getValue());
							 oivo.setProductName(pdto.getName().getValue());
							 oivo.setProductId(oidto.getProductId().getValue()+"");
							 oivo.setProductVitexId(oidto.getProductId().getValue()+"");
							 oivo.setShippingCost(oidto.getShippingCost().getValue());
							 odvo.getItems().add(oivo);
							 
						 }
					 }
					 ovo.getDeliveries().add(odvo);
				 }
			 }
			
		}
		
		return ovo;
	}

}
