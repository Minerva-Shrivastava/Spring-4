package com.yash.springpemapp.dao;

import java.util.List;

import com.yash.springpemapp.domain.Expense;

public interface ExpenseDAO {

	void save(Expense expense);
	
	void update(Expense expense);
	
	void delete(Expense expense);
	
	void delete(Integer expenseId);
	
	Expense findById(Integer expenseId);
	
	List<Expense> findAll();
	
	List<Expense> findByProperty(String propertyName, Object propertyValue);
}
