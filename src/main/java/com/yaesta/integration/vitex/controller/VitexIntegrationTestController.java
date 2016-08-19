package com.yaesta.integration.vitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.mail.ItemInfo;
import com.yaesta.app.mail.MailInfo;
import com.yaesta.app.mail.MailParticipant;
import com.yaesta.app.mail.MailService;
import com.yaesta.app.persistence.entity.Brand;
import com.yaesta.app.persistence.entity.Category;
import com.yaesta.app.persistence.entity.Product;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.integration.vitex.json.bean.OrderCancel;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.service.CategoryVitexService;
import com.yaesta.integration.vitex.service.OrderVitexService;
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
	OrderVitexService orderVitexService;
	
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
			mailInfo.setSubject("TEST de email ==>>");
			
			mailInfo.setMailSender(sender);
			mailInfo.setMailReceiver(receiver);
			
			mailInfo.getAttachmentList().add("/home/cristhian/fugu/yaesta/GuiaPdf-1469219983583-null-648881335683-01.pdf");
			
			ItemInfo item = new ItemInfo();
			item.setName("laptop");
			item.setRefCode("234");
			item.setUrl("http://yaesta.vteximg.com.br/arquivos/ids/155751-100-100/apple-macbook-pro-intel-core-i5-133-md101lla.jpg");
			//mailService.sendMail(mailInfo);
			mailInfo.setGeneralText("Prueba de correo");
			mailInfo.setItemInfo(item);
			mailInfo.getItemInfoList().add(item);
			mailService.sendMailTemplate(mailInfo, "guideNotification.vm");
			//mailService.sendEmailWithoutTemplating();
			
		}catch(Exception e){
			result = "Error en email "+ e.getMessage();
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testCancelOrder/", method = RequestMethod.GET)
	public ResponseEntity<OrderCancel> testCancelOrder(){
		String orderId = "655002549427-01";
		
		OrderComplete oc = orderVitexService.getOrderComplete(orderId);
		OrderCancel response = orderVitexService.cancelOrder(oc);
		
		return new ResponseEntity<OrderCancel>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/testChangeOrder/", method = RequestMethod.GET)
	public ResponseEntity<OrderComplete> testChangeOrder(){
		String orderId = "655012405841-01";
		String action = "approved";
		OrderComplete response = orderVitexService.changeStatus(orderId, action);
		
		return new ResponseEntity<OrderComplete>(response, HttpStatus.OK);
	}
	
}
