package com.yash.springpemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;
import com.yash.springpemapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;
	
	public void save(Category category) {
		categoryDAO.save(category);
	}

	public void update(Category category) {
		categoryDAO.update(category);
	}

	public void delete(Category category) {
		categoryDAO.delete(category);
	}

	public void delete(Integer categoryId) {
		categoryDAO.delete(categoryId);
	}

	public Category findById(Integer categoryId) {
		return categoryDAO.findById(categoryId);
	}

	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	public List<Category> findByProperty(String propertyName, Object propertyValue) {
		return categoryDAO.findByProperty(propertyName, propertyValue);
	}

}
