package com.yaesta.integration.sellercenter.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.rest.RestTemplateJSON;
import com.yaesta.app.rest.RestTemplateTEXTPLAIN;
import com.yaesta.app.service.SystemOutService;
import com.yaesta.integration.sellercenter.json.bean.SellerUser;
import com.yaesta.integration.sellercenter.json.bean.UserBean;
import com.yaesta.integration.sellercenter.json.bean.UserResponseContainer;
import com.yaesta.integration.sellercenter.json.bean.UserResponseError;


@Service
public class SellerCenterService {

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	protected @Value("${sellercenter.service.url}") String serviceUrl;
	
	
	private Client client;
	private WebTarget target;
	
	@Autowired
	SystemOutService systemOut;
	
	

	@SuppressWarnings("unchecked")
	public List<SellerUser> getSellerUsers(){
		List<SellerUser> result = new ArrayList<SellerUser>();
		
			
		String restUrl = serviceUrl + "/usuarios";
		RestTemplateTEXTPLAIN restTemplate = new RestTemplateTEXTPLAIN();		
		String resultText = restTemplate.getForObject(restUrl, String.class);
		int index =resultText.indexOf("[");
		systemOut.println(resultText);
		systemOut.println("index "+index);
		resultText = resultText.substring(index, resultText.length());
		systemOut.println(resultText);
		
		result = new Gson().fromJson(resultText, List.class);
		
		return result;
	}
	
	public UserResponseContainer createUser(UserBean sellerUser){
		UserResponseContainer response = new UserResponseContainer();
		
		String restUrl = serviceUrl + "/crearUsuario";
		
		Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
		
		String json = gson.toJson(sellerUser);
		systemOut.println(json);
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
		
		systemOut.println("Usuario:"+json);
		String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(json), String.class);
		responseJson = responseJson.trim();
		systemOut.println("==>>"+responseJson);
		
		String respJ[] = responseJson.split("\\{");
		
		String jsonObj = "{"+respJ[1] +"{"+respJ[2];
		
		systemOut.println("jsonObj "+jsonObj);
		
		if(!responseJson.contains("error")){
		
			response = gson.fromJson(jsonObj, UserResponseContainer.class);
		}else{
			
			UserResponseError resp = gson.fromJson(jsonObj, UserResponseError.class);
		
			response.setEstado(resp.getEstado());
			response.setMsg(resp.getMsg());
		}
		
		return response;
		
		
	}
	
	
	public UserResponseContainer createUserBean(UserBean sellerUser){
		UserResponseContainer response = new UserResponseContainer();
		
		String restUrl = serviceUrl + "/crearUsuario";
		
		RestTemplateJSON restTemplate = new RestTemplateJSON();
		
		Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
		
		String json = gson.toJson(sellerUser);
		systemOut.println(json);
		
		String responseJson = restTemplate.postForObject(restUrl, json, String.class);
		
		systemOut.println(responseJson);
		
		response = gson.fromJson(responseJson, UserResponseContainer.class);
		return response;
		
		
	}
}
