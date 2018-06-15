package com.yash.springpemapp.userdaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.UserDAO;
import com.yash.springpemapp.domain.User;

public class TestUserDAOFindByIdOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		User user = userDAO.findById(3);
		
		System.out.println("User found : ");
		System.out.println(user.getName());
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
