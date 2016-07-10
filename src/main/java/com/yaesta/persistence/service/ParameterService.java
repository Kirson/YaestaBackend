package com.yaesta.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.Parameter;
import com.yaesta.persistence.repository.ParameterRepository;

@Service
public class ParameterService {

	@Autowired
	ParameterRepository parameterRepository;
	
	public List<Parameter> getAll(){
		return parameterRepository.findAll();
	}
	
	public Parameter findByNemonic(String nemonic){
		return parameterRepository.findByNemonic(nemonic);
	}
}
