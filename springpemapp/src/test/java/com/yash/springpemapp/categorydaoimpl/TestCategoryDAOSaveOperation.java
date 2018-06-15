package com.yash.springpemapp.categorydaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;

public class TestCategoryDAOSaveOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		CategoryDAO categoryDAO = ctx.getBean(CategoryDAO.class);
		
		Category category = new Category();
		category.setName("food");
		category.setUserId(4);
		
		categoryDAO.save(category);
		System.out.println("----------Category Saved!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
