package com.yash.springpemapp.dao;

import java.util.List;

import com.yash.springpemapp.domain.User;

public interface UserDAO {

	void save(User user);
	
	void update(User user);
	
	void delete(User user);
	
	void delete(Integer userId);
	
	User findById(Integer userId);
	
	List<User> findAll();
	
	List<User> findByProperty(String propertyName, Object propertyValue);
	
	User login(String loginName, String password);
	
 }
