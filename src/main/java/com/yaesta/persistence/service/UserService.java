package com.yaesta.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.persistence.entity.User;
import com.yaesta.persistence.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User findByVitextId(String vitexId){
		return userRepository.findByVitexId(vitexId);
	}
	
}
