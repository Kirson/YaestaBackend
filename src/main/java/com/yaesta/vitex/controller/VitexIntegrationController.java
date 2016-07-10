package com.yaesta.vitex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.persistence.entity.Brand;
import com.yaesta.persistence.entity.Category;
import com.yaesta.persistence.entity.Product;
import com.yaesta.persistence.entity.Supplier;
import com.yaesta.vitex.service.CategoryVitexService;
import com.yaesta.vitex.service.OrderVitexService;
import com.yaesta.vitex.service.ProductVitexService;
import com.yaesta.vitex.vo.OrderVO;
import com.yaesta.vitex.wsdl.dto.ArrayOfOrderDTO;
import com.yaesta.vitex.wsdl.dto.CategoryDTO;
import com.yaesta.vitex.wsdl.dto.OrderDTO;
import com.yaesta.vitex.wsdl.dto.ProductDTO;

@RestController
@RequestMapping(value = "/vitextIntegration")
public class VitexIntegrationController {

	@Autowired
	ProductVitexService productVitexService;
	
	@Autowired
	CategoryVitexService categoryVitexService;
	
	@Autowired
	OrderVitexService orderVitexService;
	
	@RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) {	  		 		
		System.out.println("==>>1<<===");
		
		ProductDTO product = productVitexService.findById(id);	
		System.out.println("==>>2<<===");
		return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
	}
	
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
		//System.out.println("==>>A<<===");
		Category category = new Category();
		category.setName("Cate");
		CategoryDTO result = categoryVitexService.createCategory(category);
		//System.out.println("==>>B<<===");
		return new ResponseEntity<CategoryDTO>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getOrdersNext50Vitex{sequence}", method = RequestMethod.GET)
	public ResponseEntity<ArrayOfOrderDTO> getOrdersNext50Vitex(@PathVariable("sequence") Integer sequence) {	  		 		
		//System.out.println("==>>1<<===");
		ArrayOfOrderDTO resultList = orderVitexService.getOrders(sequence);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<ArrayOfOrderDTO>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrdersNext50{sequence}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderVO>> getOrdersNext50(@PathVariable("sequence") Integer sequence) {	  		 		
		//System.out.println("==>>1<<===");
		List<OrderVO> resultList = orderVitexService.getOrdersNext50(sequence);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<List<OrderVO>>(resultList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findOrderById{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") Integer id) {	  		 		
		//System.out.println("==>>1<<===");
		
		OrderDTO order = orderVitexService.findById(id);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrderById{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") String id) {	  		 		
		//System.out.println("==>>1<<===");
		
		OrderDTO order = orderVitexService.findOrderById(id);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOrder{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderVO> getOrder(@PathVariable("id") String id) {	  		 		
		//System.out.println("==>>1<<===");
		
		OrderVO order = orderVitexService.findOrder(id);
		//System.out.println("==>>2<<===");
		return new ResponseEntity<OrderVO>(order, HttpStatus.OK);
	}
	
}
