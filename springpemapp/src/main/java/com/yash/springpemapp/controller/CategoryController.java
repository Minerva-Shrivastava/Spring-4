package com.yash.springpemapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springpemapp.domain.Category;
import com.yash.springpemapp.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}
	
	@GetMapping("/categories/{userId}")
	public List<Category> getListOfCategoryByUserId(@PathVariable Integer userId) {
		return categoryService.findByProperty("userId", userId);
	}
	
	@GetMapping("/category/{categoryId}")
	public Category getCategoryByCategoryId(@PathVariable Integer categoryId) {
		return categoryService.findById(categoryId);
	}

	@GetMapping(value = "/categories/{propertyName}/{propertyValue}")
	public List<Category> searchByProperty(@PathVariable("propertyName") String propertyName, @PathVariable("propertyValue") String propertyValue){
		return categoryService.findByProperty(propertyName, propertyValue);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/category")
	public ResponseEntity addNewCategory(@RequestBody Category category) {
		categoryService.save(category);
		return new ResponseEntity(HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/category")
	public ResponseEntity updateCategory(@RequestBody Category category) {
		categoryService.update(category);
		return new ResponseEntity(HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity deleteCategoryById(@PathVariable Integer categoryId) {
		categoryService.delete(categoryId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/category")
	public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
		categoryService.delete(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	
}
