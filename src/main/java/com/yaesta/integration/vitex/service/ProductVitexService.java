package com.yaesta.integration.vitex.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.service.BrandService;
import com.yaesta.app.persistence.service.CategoryService;
import com.yaesta.app.service.SystemOutService;
import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.wsdl.ProductGet;
import com.yaesta.integration.vitex.wsdl.ProductGetResponse;
import com.yaesta.integration.vitex.wsdl.ProductInsertUpdate;
import com.yaesta.integration.vitex.wsdl.ProductInsertUpdateResponse;
import com.yaesta.integration.vitex.wsdl.dto.ProductDTO;


@Service
public class ProductVitexService extends BaseVitexService  {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2169306017867783635L;
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SystemOutService systemOut;
	
	public ProductVitexService() throws Exception{}
	
	public ProductDTO findById(Integer productId){
		ProductGet query = objectFactory.createProductGet();
		query.setIdProduct(productId);
		//systemOut.println("==>>A");
		ProductGetResponse response = (ProductGetResponse)webServiceTemplate.marshalSendAndReceive(query,new SoapActionCallback("http://tempuri.org/IService/ProductGet"));
		//systemOut.println("==>>B");
		return response.getProductGetResult().getValue();
		
	}
	
	public Product getVitexProduct(Integer productId){
		Product result = new Product();
		
		ProductDTO vitexProduct = findById(productId);
		if(vitexProduct!=null){
			result.setName(vitexProduct.getName().getValue());
			result.setDescription(vitexProduct.getDescription().getValue());
			result.setVitexId(vitexProduct.getId().getValue()+"");
			if(vitexProduct.getBrandId()!=null){
				result.setBrand(brandService.findByVitexId(vitexProduct.getBrandId().getValue()+""));
			}
			if(vitexProduct.getCategoryId()!=null){
				result.setCategory(categoryService.findByVitexId(vitexProduct.getCategoryId().getValue()+""));
			}
			/*
			if(vitexProduct.getDepartmentId()!=null){
				result.setCategory(categoryService.findByVitexId(vitexProduct.getCategoryId().getValue()+""));
			}*/
			
		}
		
		
		return result;
		
	}
	
	/**
	 * Create a simple product into VTex eCommerce
	 * @param product
	 * @return
	 */
	public ProductDTO createProduct(Product product){
		ProductDTO dto = objectFactory.createProductDTO();
		
		if(product.getBrand()!=null){
			dto.setBrandId(objectFactory.createInt(new Integer(product.getBrand().getVitexId())));
		}
		dto.setDescription(objectFactory.createString(product.getDescription()));
		dto.setName(objectFactory.createString(product.getName()));
		dto.setRefId(objectFactory.createString(product.getId()+""));
		
		if(product.getCategory()!=null){
			systemOut.println("==>>>"+product.getCategory().getVitexId());
			dto.setCategoryId(objectFactory.createInt(new Integer(product.getCategory().getVitexId())));
			dto.setDepartmentId(objectFactory.createInt(new Integer(product.getCategory().getVitexId())));
			systemOut.println("++>>>"+dto.getCategoryId().getValue());
		}
		if(product.getSupplier()!=null){
			dto.setSupplierId(objectFactory.createInt(new Integer(product.getSupplier().getVitexId())));
		}
		ProductInsertUpdate piu = objectFactory.createProductInsertUpdate();
		
		//objectFactory.createProductInsertUpdateProductVO(value)
		
		//piu.setProductVO(objectFactory.createProductInsertUpdateProductVO(dto));
		piu.setProductVO(objectFactory.createProductInsertUpdateProductVO(dto));
		systemOut.println("****>>>"+ piu.getProductVO().getValue().getCategoryId().getValue());
		systemOut.println("****>>>"+ piu.getProductVO().getValue().getName().getValue());
		//piu.wait(1000);
		
		ProductInsertUpdateResponse piuResponse = (ProductInsertUpdateResponse)webServiceTemplate.marshalSendAndReceive(piu,new SoapActionCallback("http://tempuri.org/IService/ProductInsertUpdate"));
		//ProductInsertUpdateResponse piuResponse = (ProductInsertUpdateResponse)webServiceTemplate.marshalSendAndReceive(piu);
		return piuResponse.getProductInsertUpdateResult().getValue();
	}
	
}
