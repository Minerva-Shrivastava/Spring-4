package com.yash.springpemapp.categorydaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;

public class TestCategoryDAOUpdateOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		CategoryDAO categoryDAO = ctx.getBean(CategoryDAO.class);
		
		Category category = new Category();
		category.setId(1);
		category.setName("travel");
		category.setUserId(4);
		
		categoryDAO.update(category);
		System.out.println("----------Category Updated!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
