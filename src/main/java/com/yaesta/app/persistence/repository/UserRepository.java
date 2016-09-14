package com.yaesta.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	public User findByLogin(String login);
	public User findByVitexId(String vitexId);
	public List<User> findByRole(Catalog role);
	public User findByLoginAndPassword(String login, String password);
}
