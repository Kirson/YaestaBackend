package com.yaesta.integration.laarcourier.service;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.yaesta.integration.laarcourier.wsdl.CreateWayBill;
import com.yaesta.integration.laarcourier.wsdl.CreateWayBillResponse;
import com.yaesta.integration.laarcourier.wsdl.ObjectFactory;
import com.yaesta.integration.laarcourier.wsdl.WayBill;
import com.yaesta.integration.laarcourier.wsdl.WayBillResponse;
import com.yaesta.integration.vitex.json.bean.OrderComplete;


@Service
public class LaarCourierService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 5925730747038577685L;
	
	@Autowired
	private WebServiceTemplate webServiceTemplateLaarCourier;
	
	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;
	

	protected @Value("${laarcourier.service.user}") String laarCourierServiceUser;
	protected @Value("${laarcourier.service.password}") String laarCourierServicePassword;
	
	
	public WayBillResponse processWayBill(OrderComplete orderComplete){
		WayBillResponse response = new WayBillResponse();
		
		try {
			ObjectFactory objectFactory =new ObjectFactory();
			
			WayBill waybill = objectFactory.createWayBill();
			waybill.setUsername(objectFactory.createWayBillUsername(laarCourierServiceUser));
			waybill.setPassword(objectFactory.createWayBillUsername(laarCourierServicePassword));
			//getter/setter
			
			CreateWayBill input = objectFactory.createCreateWayBill();
			input.setObjWayBillDetails(objectFactory.createCreateWayBillObjWayBillDetails(waybill));
			
			CreateWayBillResponse cResponse = (CreateWayBillResponse)webServiceTemplateLaarCourier.marshalSendAndReceive(input,new SoapActionCallback("http://tempuri.org/IWayBillInfo/CreateWayBill"));
			
			response = cResponse.getCreateWayBillResult().getValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}
