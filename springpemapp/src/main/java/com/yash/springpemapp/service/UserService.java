package com.yash.springpemapp.service;

import java.util.List;

import com.yash.springpemapp.domain.User;
import com.yash.springpemapp.exception.BlockUserException;

public interface UserService {

	static final Integer LOGIN_STATUS_ACTIVE = 1;
	static final Integer LOGIN_STATUS_BLOCKED = 2;
	static final Integer ROLE_ADMIN = 1;
	static final Integer ROLE_USER = 2;
	
	void register (User user);
	
	User login(String loginName, String password) throws BlockUserException;
	
	List<User> getUserList();
	
	void changeLoginStatus(Integer  userId, Integer loginStatus);
	
	void update(User user);

	void delete(User user);
	
	void delete(Integer userId);
	
	User getUserById(Integer id);
	
	List<User> findByProperty(String propertyName, Object propertyValue);
	
}

