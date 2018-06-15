package com.yash.springpemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;
import com.yash.springpemapp.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseDAO expenseDAO;
	
	public void save(Expense expense) {
		expenseDAO.save(expense);
	}

	public void update(Expense expense) {
		expenseDAO.update(expense);
	}

	public void delete(Expense expense) {
		expenseDAO.delete(expense);
	}

	public void delete(Integer expenseId) {
		expenseDAO.delete(expenseId);
	}

	public Expense findById(Integer expenseId) {
		return expenseDAO.findById(expenseId);
	}

	public List<Expense> findAll() {
		return expenseDAO.findAll();
	}

	public List<Expense> findByProperty(String propertyName, Object propertyValue) {
		return expenseDAO.findByProperty(propertyName, propertyValue);
	}

}
