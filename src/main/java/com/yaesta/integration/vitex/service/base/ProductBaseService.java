package com.yaesta.integration.vitex.service.base;

import javax.xml.bind.JAXBElement;

import com.yaesta.app.persistence.entity.Product;
import com.yaesta.integration.vitex.wsdl.dto.ProductDTO;

public class ProductBaseService extends BaseVitexService {

	

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1059673061815023819L;

	public ProductBaseService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTO fromProduct(Product product){
		
		ProductDTO result = objectFactory.createProductDTO();
		
		if(product!=null){
			if(product.getDescription()!=null){
				result.setDescription(new JAXBElement<String>(null, String.class,product.getDescription()));
			}
		}
		return result;
	}
	
}
