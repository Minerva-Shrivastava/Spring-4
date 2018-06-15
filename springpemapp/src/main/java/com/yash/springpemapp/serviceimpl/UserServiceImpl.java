package com.yash.springpemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springpemapp.dao.UserDAO;
import com.yash.springpemapp.domain.User;
import com.yash.springpemapp.exception.BlockUserException;
import com.yash.springpemapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public void register(User user) {
		
		userDAO.save(user);
	}

	public User login(String loginName, String password) throws BlockUserException {
		
		User user = null;
		user = userDAO.login(loginName, password);
		
		if( user != null) {
			user.setStatus(LOGIN_STATUS_ACTIVE);
			this.update(user);
		}else {
			throw new BlockUserException("username or password is incorrect");
		}
		return user;
	}

	public List<User> getUserList() {
		return userDAO.findAll();
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		User user = userDAO.findById(userId);
		user.setStatus(loginStatus);
		this.update(user);
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public User getUserById(Integer id) {
		return userDAO.findById(id);
	}

	public List<User> findByProperty(String propertyName, Object propertyValue) {
		return userDAO.findByProperty(propertyName, propertyValue);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public void delete(Integer userId) {
		userDAO.delete(userId);
	}

	
}
