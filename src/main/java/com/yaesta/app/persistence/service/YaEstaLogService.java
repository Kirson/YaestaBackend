package com.yaesta.app.persistence.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.YaEstaLogRepository;

@Service
public class YaEstaLogService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8685035589734782340L;
	
	@Autowired
	private YaEstaLogRepository repository;
	
	public List<YaEstaLog> getAll(){
		return repository.findAll();
	}
	
	public YaEstaLog save(YaEstaLog entity){
		return repository.save(entity);
	}
	
	public List<YaEstaLog> findByOrderId(String orderId){
		return repository.findByOrderId(orderId);
	}
}
