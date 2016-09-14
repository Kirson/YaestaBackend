package com.yaesta.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yaesta.app.persistence.entity.User;
import com.yaesta.app.persistence.service.UserService;
import com.yaesta.app.persistence.vo.UserVO;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<User>> getAll(){
		
		List<User> found = userService.getUsers();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<User>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<User>>(new ArrayList<User>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<User> update(@RequestBody UserVO userVO){
		
		User response = userService.save(userVO.getUser());
		
		return new ResponseEntity<User>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByLoginPassword/{login}/{password}", method = RequestMethod.GET)
	public  ResponseEntity<User> findByLoginPassword(@PathVariable("login")String login,@PathVariable("password") String password){
		
		User found = userService.findByLoginAndPassword(login, password);
	
	    if(found!=null){
	    	return new ResponseEntity<User>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<User>(new User(),HttpStatus.OK);
	    }
	}

}
