package com.yaesta.app.persistence.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.yaesta.app.persistence.entity.Customer;

public interface ClientPageRepository extends PagingAndSortingRepository<Customer,Long> {

	
}
