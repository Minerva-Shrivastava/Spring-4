package com.yash.springpemapp.expensedaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;

public class TestExpenseDAOFindByIdOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ExpenseDAO expenseDAO = ctx.getBean(ExpenseDAO.class);
		
		Expense expense = expenseDAO.findById(1);
		
		System.out.println("Expense found : ");
		System.out.println(expense);
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
