package com.yash.springpemapp.categorydaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;

public class TestCategoryDAODeleteOperation {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		CategoryDAO categoryDAO = ctx.getBean(CategoryDAO.class);
		
		//categoryDAO.delete(2);
		
		Category category = new Category();
		category.setId(1);
		categoryDAO.delete(category);
		
		System.out.println("----------Category "+ category.getId() +" Deleted!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
