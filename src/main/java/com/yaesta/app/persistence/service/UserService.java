package com.yaesta.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.User;
import com.yaesta.app.persistence.repository.UserRepository;


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
	
	@Transactional
	public User save(User user){
		if(user.getUserRole()!=null){
			user.setRole(user.getUserRole());
		}
		return userRepository.save(user);
	}
	
	public User findByLoginAndPassword(String login, String password){
		return userRepository.findByLoginAndPassword(login, password);
	}
}
