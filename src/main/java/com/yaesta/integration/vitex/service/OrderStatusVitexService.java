package com.yaesta.integration.vitex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.wsdl.OrderStatusGetAll;
import com.yaesta.integration.vitex.wsdl.OrderStatusGetAllResponse;
import com.yaesta.integration.vitex.wsdl.dto.OrderStatusDTO;
import com.yaesta.integration.vitex.wsdl.vo.OrderStatusVO;

@Service
public class OrderStatusVitexService  extends BaseVitexService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3358554096540347669L;
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	public OrderStatusVitexService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<OrderStatusDTO> getStatusList(){
		
		OrderStatusGetAll query =  objectFactory.createOrderStatusGetAll();
		
		OrderStatusGetAllResponse response = (OrderStatusGetAllResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/OrderStatusGetAll"));
		
		return response.getOrderStatusGetAllResult().getValue().getOrderStatusDTO();
	}
	
	public List<OrderStatusVO> getOrderStatusList(){
		List<OrderStatusVO> result = new ArrayList<OrderStatusVO>();
		
		List<OrderStatusDTO> query =  getStatusList();
		if(query!=null && !query.isEmpty()){
			for(OrderStatusDTO osd:query){
				OrderStatusVO osv = new OrderStatusVO();
				osv.setId(osd.getId().getValue());
				osv.setDescription(osd.getDescription().getValue());
				result.add(osv);
			}
		}
		
		return result;
	}
}
