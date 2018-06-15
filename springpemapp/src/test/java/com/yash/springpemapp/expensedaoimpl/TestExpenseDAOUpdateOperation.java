package com.yash.springpemapp.expensedaoimpl;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;

public class TestExpenseDAOUpdateOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ExpenseDAO expenseDAO = ctx.getBean(ExpenseDAO.class);
		
		Expense expense = new Expense();
		expense.setId(1);
		expense.setAmount(100);
		expense.setCategoryId(4);
		expense.setDate(Date.valueOf("2018-06-12"));
		expense.setRemark("food expenses on this day");
		
		expenseDAO.update(expense);
		System.out.println("----------Expense Updated!----------");
		
		((ConfigurableApplicationContext)ctx).close();

	}
}
