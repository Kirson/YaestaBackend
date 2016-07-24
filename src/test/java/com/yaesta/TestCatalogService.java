package com.yaesta;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.EnvironmentTestUtils;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.service.CatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class TestCatalogService {
	
	@Autowired
	CatalogService service;

	@Test
	public void testGetAll() {
		
		List<Catalog> all = service.getAll();
		
		if(all!=null && !all.isEmpty()){
			for(Catalog c:all){
				System.out.println(c.getName());
			}
		 assert(true);	
		}else
		{
		fail("Not yet implemented");
		}
	}

	@Test
	public void testGetMainCatalogs() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByMainCatalog() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByVitexId() {
		fail("Not yet implemented");
	}

}
