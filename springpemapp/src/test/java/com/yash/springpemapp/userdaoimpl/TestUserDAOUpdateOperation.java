package com.yash.springpemapp.userdaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.UserDAO;
import com.yash.springpemapp.domain.User;

public class TestUserDAOUpdateOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		User user = new User();
		user.setUserId(3);
		user.setName("Mansi Jain");
		user.setPhone("0980986786");
		user.setEmail("mansi@gmail.com");
		user.setLoginName("Mansi");
		user.setPassword("123");
		
		userDAO.update(user);
		System.out.println("----------User Updated!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
