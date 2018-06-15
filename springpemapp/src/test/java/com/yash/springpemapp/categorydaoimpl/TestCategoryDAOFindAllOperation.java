package com.yash.springpemapp.categorydaoimpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;

public class TestCategoryDAOFindAllOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		CategoryDAO categoryDAO = ctx.getBean(CategoryDAO.class);
		
		List<Category> categories = categoryDAO.findAll();
		
		for (Category category : categories) {
			System.out.println(category);
		}
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
