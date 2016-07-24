package com.yaesta.integration.vitex.service;

import java.io.IOException;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.SoapMessage;

import com.yaesta.app.persistence.entity.Category;
import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.wsdl.CategoryGet;
import com.yaesta.integration.vitex.wsdl.CategoryGetResponse;
import com.yaesta.integration.vitex.wsdl.CategoryInsertUpdate;
import com.yaesta.integration.vitex.wsdl.CategoryInsertUpdateResponse;
import com.yaesta.integration.vitex.wsdl.dto.CategoryDTO;

@Service
public class CategoryVitexService extends BaseVitexService  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5122684341580125548L;
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	public CategoryVitexService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDTO findById(Integer categoryId){
		CategoryGet query = objectFactory.createCategoryGet();
		query.setIdCategory(categoryId);
		//System.out.println("==>>A");
		CategoryGetResponse response = (CategoryGetResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/CategoryGet"));
		//System.out.println("==>>B");
		return response.getCategoryGetResult().getValue();
		
	}
	
	public CategoryDTO createCategory(Category category){
		CategoryDTO dto = objectFactory.createCategoryDTO();
		JAXBElement<String> strName = objectFactory.createString("");
		strName.setValue(category.getName());
		dto.setName(strName);
		dto.setTitle(strName);
	    
		CategoryInsertUpdate ciu = objectFactory.createCategoryInsertUpdate();
		ciu.setCategory(objectFactory.createCategoryInsertUpdateCategory(dto));
		System.out.println("==>>  "+ciu.getCategory().getValue().getName().getValue());
		
		//webServiceTemplate.setDefaultUri("http://tempuri.org/IService/CategoryInsertUpdate");
		//CategoryInsertUpdateResponse ciuResponse =  (CategoryInsertUpdateResponse)webServiceTemplate.marshalSendAndReceive(ciu,new SoapActionCallback("http://tempuri.org/IService/CategoryInsertUpdate"));
		CategoryInsertUpdateResponse ciuResponse =  (CategoryInsertUpdateResponse)webServiceTemplate.marshalSendAndReceive(ciu,new WebServiceMessageCallback() {
			@Override
			public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
	            ((SoapMessage)message).setSoapAction("http://tempuri.org/IService/CategoryInsertUpdate");
	        }

		}
			
);
		return ciuResponse.getCategoryInsertUpdateResult().getValue();
	}
}
