package com.yaesta.integration.sellercenter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.rest.RestTemplateJSON;
import com.yaesta.app.rest.RestTemplateTEXTPLAIN;
import com.yaesta.integration.sellercenter.json.bean.SellerUser;


@Service
public class SellerCenterService {

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	protected @Value("${sellercenter.service.url}") String serviceUrl;
	
	
	
	
	

	@SuppressWarnings("unchecked")
	public List<SellerUser> getSellerUsers(){
		List<SellerUser> result = new ArrayList<SellerUser>();
		
			
		String restUrl = serviceUrl + "/usuarios";
		RestTemplateTEXTPLAIN restTemplate = new RestTemplateTEXTPLAIN();		
		String resultText = restTemplate.getForObject(restUrl, String.class);
		int index =resultText.indexOf("[");
		System.out.println(resultText);
		System.out.println(index);
		resultText = resultText.substring(index, resultText.length());
		System.out.println(resultText);
		
		result = new Gson().fromJson(resultText, List.class);
		
		return result;
	}
	
	public SellerUser createUser(SellerUser sellerUser){
		String restUrl = serviceUrl + "/crearUsuario";
		
		RestTemplateJSON restTemplate = new RestTemplateJSON();
		
		Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
		
		String json = gson.toJson(sellerUser);
		System.out.println(json);
		
		//restTemplate.put(restUrl, sellerUser);
		String response = restTemplate.postForObject(restUrl, json, String.class);
		
		System.out.println(response);
		
		return sellerUser;
	}
}
