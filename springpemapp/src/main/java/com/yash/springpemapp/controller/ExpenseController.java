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

import com.yash.springpemapp.domain.Expense;
import com.yash.springpemapp.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.findAll();
	}
	
	@GetMapping("/expenses/{categoryId}")
	public List<Expense> getAllExpensesByCategoryId(@PathVariable Integer categoryId){
		return expenseService.findByProperty("categoryId", categoryId);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/expense/{expenseId}")
	public ResponseEntity getExpensesByExpenseId(@PathVariable Integer expenseId){
			Expense expense = expenseService.findById(expenseId);
			if(expense == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@GetMapping(value = "/expenses/{propertyName}/{propertyValue}")
	public List<Expense> searchByProperty(@PathVariable("propertyName") String propertyName, @PathVariable("propertyValue") String propertyValue){
		return expenseService.findByProperty(propertyName, propertyValue);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/expense")
	public ResponseEntity addNewExpense(@RequestBody Expense expense) {
		expenseService.save(expense);
		return new ResponseEntity(expense,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@PutMapping("/expense")
	public ResponseEntity updateExpense(@RequestBody Expense expense) {
		Expense expenseGiven = expenseService.findById(expense.getId());
		if(expenseGiven == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		expenseService.update(expenseGiven);
		return new ResponseEntity(HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/expense/{expenseId}")
	public ResponseEntity deleteExpenseById(@PathVariable Integer expenseId) {
		expenseService.delete(expenseId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/expense")
	public ResponseEntity<Expense> deleteExpense(@RequestBody Expense expense) {
		expenseService.delete(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
}
