package com.yash.springpemapp.dao;

import java.util.List;

import com.yash.springpemapp.domain.Category;

public interface CategoryDAO {

	void save(Category category);
	
	void update(Category category);
	
	void delete(Category category);
	
	void delete(Integer categoryId);
	
	Category findById(Integer categoryId);
	
	List<Category> findAll();
	
	List<Category> findByProperty(String propertyName, Object propertyValue);

}
