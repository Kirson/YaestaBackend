package com.yaesta.app.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Parameter;
import com.yaesta.app.persistence.repository.ParameterRepository;

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
