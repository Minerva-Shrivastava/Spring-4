package com.yash.springpemapp.service;

import java.util.List;

import com.yash.springpemapp.domain.Expense;

public interface ExpenseService {

	void save(Expense expense);
	
	void update(Expense expense);
	
	void delete(Expense expense);
	
	void delete(Integer expenseId);
	
	Expense findById(Integer expenseId);
	
	List<Expense> findAll();
	
	List<Expense> findByProperty(String propertyName, Object propertyValue);
	
}
