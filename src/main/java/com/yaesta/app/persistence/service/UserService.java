package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.User;
import com.yaesta.app.persistence.repository.UserRepository;
import com.yaesta.app.persistence.vo.UserProcessVO;
import com.yaesta.app.util.PasswordUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${yaesta.password.key}") String yaestaPasswordKey;
	private @Value("${yaesta.password.vector}") String yaestaPasswordVector;
	private @Value("${yaesta.encript.flag}") String yaestaEncriptFlag;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User findByVitextId(String vitexId) {
		return userRepository.findByVitexId(vitexId);
	}

	@Transactional
	public User save(User user) {
		if (user.getUserRole() != null) {
			user.setRole(user.getUserRole());
		}
		if (yaestaEncriptFlag != null && yaestaEncriptFlag.equals("Y")) {
			try {
				String encriptPwd = PasswordUtil.encrypt(yaestaPasswordKey, yaestaPasswordVector, user.getPassword());
				user.setPassword(encriptPwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userRepository.save(user);
	}

	public User findByLoginAndPassword(String login, String password) {
		if (yaestaEncriptFlag != null && yaestaEncriptFlag.equals("Y")) {
			try {
				String encriptPwd = PasswordUtil.encrypt(yaestaPasswordKey, yaestaPasswordVector, password);
				password = encriptPwd;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userRepository.findByLoginAndPassword(login, password);
	}
	
	/**
	 * DecriptPassword
	 * @param login
	 * @return
	 */
	public List<User> getDecriptPassword(String login){
		
		List<User> query = userRepository.findByLogin(login);
		List<User> result = new ArrayList<User>();
		
		if(query!=null && !query.isEmpty()){
			for(User u:query){
				String decript = "";
				try {
					 decript = PasswordUtil.decrypt(yaestaPasswordKey, yaestaPasswordVector, u.getPassword());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				u.setClearPassword(decript);
				result.add(u);
			}
		}
		
		return result;
	}

	@Transactional
	public UserProcessVO updateUserPasswords() {
		UserProcessVO upVO = new UserProcessVO();
		upVO.setResult("OK");
		List<User> founds = getUsers();
		if (founds != null && !founds.isEmpty()) {
			Long count = 0L;
			for (User u : founds) {
				try {
					if (yaestaEncriptFlag != null && yaestaEncriptFlag.equals("Y")) {
						count++;
						String encriptPwd = PasswordUtil.encrypt(yaestaPasswordKey, yaestaPasswordVector,u.getPassword());
						u.setPassword(encriptPwd);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					upVO.getExceptionList().add(e.getMessage());
					upVO.setResult("ERROR");
					e.printStackTrace();
				}
				userRepository.save(u);
			}
			upVO.setCount(count);
		}

		return upVO;
	}
}
