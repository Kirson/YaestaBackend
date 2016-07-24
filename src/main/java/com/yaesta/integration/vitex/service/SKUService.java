package com.yaesta.integration.vitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.wsdl.StockKeepingUnitGet;
import com.yaesta.integration.vitex.wsdl.StockKeepingUnitGetResponse;
import com.yaesta.integration.vitex.wsdl.dto.StockKeepingUnitDTO;

@Service
public class SKUService extends BaseVitexService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 439824194151573612L;
	
	public SKUService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;

	public StockKeepingUnitDTO  findById(Integer skuId){
		StockKeepingUnitGet query = objectFactory.createStockKeepingUnitGet();
		query.setId(skuId);
		//System.out.println("==>>A");
		StockKeepingUnitGetResponse response = (StockKeepingUnitGetResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/StockKeepingUnitGet"));
		//System.out.println("==>>B");
		return response.getStockKeepingUnitGetResult().getValue();
		
	}
}
