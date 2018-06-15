package com.yash.springpemapp.userdaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.UserDAO;
import com.yash.springpemapp.domain.User;

public class TestUserDAODeleteOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		//userDAO.delete(2);
		
		User user = new User();
		user.setUserId(1);
		userDAO.delete(user);
		
		System.out.println("----------User "+user.getUserId() +" Deleted!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
