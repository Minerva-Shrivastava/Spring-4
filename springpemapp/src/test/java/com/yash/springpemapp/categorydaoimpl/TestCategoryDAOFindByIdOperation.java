package com.yash.springpemapp.categorydaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;

public class TestCategoryDAOFindByIdOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		CategoryDAO categoryDAO = ctx.getBean(CategoryDAO.class);
		
		Category category = categoryDAO.findById(3);
		
		System.out.println("Category found : ");
		System.out.println(category.getName());
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
