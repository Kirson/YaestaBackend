package com.yaesta.integration.vitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.mail.MailInfo;
import com.yaesta.app.mail.MailParticipant;
import com.yaesta.app.mail.MailService;
import com.yaesta.app.persistence.entity.Brand;
import com.yaesta.app.persistence.entity.Category;
import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.integration.vitex.service.CategoryVitexService;
import com.yaesta.integration.vitex.service.ProductVitexService;
import com.yaesta.integration.vitex.wsdl.dto.CategoryDTO;
import com.yaesta.integration.vitex.wsdl.dto.ProductDTO;

@RestController
@RequestMapping(value = "/vitextIntegrationTest")
public class VitexIntegrationTestController {
	
	@Autowired
	ProductVitexService productVitexService;
	
	@Autowired
	CategoryVitexService categoryVitexService;
	
	@Autowired
	MailService mailService;

	@RequestMapping(value = "/createDummyProduct/", method = RequestMethod.POST)
	public ResponseEntity<ProductDTO> createDummyProduct() {	  		 		
		System.out.println("==>>A<<===");
		Product product = new Product();
		product.setName("Test");
		product.setDescription("Uno");
		product.setId(20L);
		Category cat = new Category();
		cat.setVitexId("1");
		product.setCategory(cat);
		Brand brand = new Brand();
		brand.setVitexId("2000007");
		product.setBrand(brand);
		Supplier supplier = new Supplier();
		supplier.setVitexId("1");
		product.setSupplier(supplier);
		ProductDTO result = productVitexService.createProduct(product);
		System.out.println("==>>B<<===");
		return new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/createDummyCategory/", method = RequestMethod.POST)
	public ResponseEntity<CategoryDTO> createDummyCategory() {	  		 		
		Category category = new Category();
		category.setName("Cate");
		CategoryDTO result = categoryVitexService.createCategory(category);
		return new ResponseEntity<CategoryDTO>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sendTestMail/", method = RequestMethod.GET)
	public ResponseEntity<String> sendTestMail(){
		String result = "OK";
		
		try{
			
			MailInfo mailInfo = new MailInfo();
			
			MailParticipant sender = new MailParticipant();
			MailParticipant receiver = new MailParticipant();
			
			sender.setName("Cristhian Herrera");
			sender.setEmail("cristhian.herrera@gmail.com");
			
			receiver.setName("Kirs Herrera");
			receiver.setEmail("cristhian.herrera@gruppoavanti.com");
			
			mailInfo.setBody("Prueba de correo@");
			mailInfo.setSubject("TEST de email");
			
			mailService.sendMail(mailInfo);
			
		}catch(Exception e){
			result = "Error en email "+ e.getMessage();
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
