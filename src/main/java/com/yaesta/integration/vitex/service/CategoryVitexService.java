package com.yaesta.integration.vitex.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.SoapMessage;

import com.google.gson.Gson;
import com.yaesta.app.persistence.entity.Category;
import com.yaesta.integration.vitex.json.bean.CategoryVtex;
import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.util.CategoryVtexUtil;
import com.yaesta.integration.vitex.wsdl.CategoryGet;
import com.yaesta.integration.vitex.wsdl.CategoryGetResponse;
import com.yaesta.integration.vitex.wsdl.CategoryInsertUpdate;
import com.yaesta.integration.vitex.wsdl.CategoryInsertUpdateResponse;
import com.yaesta.integration.vitex.wsdl.dto.CategoryDTO;

@Service
public class CategoryVitexService extends BaseVitexService  {

	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5122684341580125548L;
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	private Client client;
	private WebTarget target;
	
	public CategoryVitexService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDTO findById(Integer categoryId){
		CategoryGet query = objectFactory.createCategoryGet();
		query.setIdCategory(categoryId);
		CategoryGetResponse response = (CategoryGetResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/CategoryGet"));
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
		//System.out.println("==>>  "+ciu.getCategory().getValue().getName().getValue());
		
		CategoryInsertUpdateResponse ciuResponse =  (CategoryInsertUpdateResponse)webServiceTemplate.marshalSendAndReceive(ciu,new WebServiceMessageCallback() {
			@Override
			public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
	            ((SoapMessage)message).setSoapAction("http://tempuri.org/IService/CategoryInsertUpdate");
	        }

			}
			
		);
		return ciuResponse.getCategoryInsertUpdateResult().getValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoryVtex> getCategories(){
		List<CategoryVtex> result = new ArrayList<CategoryVtex>();
		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/catalog_system/pvt/category/tree/4";
		
		target = client.target(restUrl);
		
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);

		System.out.println("json category "+json );
		
		result = new Gson().fromJson(json, List.class);
			
		return result;
	}
	
	public CategoryVtex getCategoryFromPath(String path){
		
		String [] paths = path.split("/");
		System.out.println("path  "+path);
		int index = paths.length-1;
		System.out.println("index  "+index);
		
		return getCategoryFromId(new Integer(paths[index]));
		
	}
	
	public CategoryVtex getCategoryFromPath2(String path){
		System.out.println("path  "+path);
		int lastIndex = path.lastIndexOf("/");
		System.out.println("lastIndex  "+lastIndex);
		String strLast = path.substring(lastIndex+1,path.length());
		
		return getCategoryFromId(new Integer(strLast));
		
	}
	
	public CategoryVtex getCategoryFromId(Integer id){
		
		CategoryDTO cdto = findById(new Integer(id));
		
		CategoryVtex result = CategoryVtexUtil.fromCategoryDTOtoCategoryVext(cdto);
		
		return result;
		
	}
}
