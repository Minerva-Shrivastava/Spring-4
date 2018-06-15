package com.yash.springpemapp.expensedaoimpl;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;

public class TestExpenseDAOSaveOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ExpenseDAO expenseDAO = ctx.getBean(ExpenseDAO.class);
		
		Expense expense = new Expense();
		expense.setCategoryId(4);
		expense.setAmount(70);
		expense.setDate(Date.valueOf("2018-06-13"));
		expense.setRemark("Food expenses on this day");
		
		expenseDAO.save(expense);
		System.out.println("----------Expenses Saved!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
