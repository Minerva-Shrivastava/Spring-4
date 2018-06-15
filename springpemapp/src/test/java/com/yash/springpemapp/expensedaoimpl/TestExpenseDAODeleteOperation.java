package com.yash.springpemapp.expensedaoimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;

public class TestExpenseDAODeleteOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ExpenseDAO expenseDAO = ctx.getBean(ExpenseDAO.class);
		
		//userDAO.delete(2);
		
		Expense expense = new Expense();
		expense.setId(4);
		expenseDAO.delete(expense);
		
		System.out.println("----------Expense "+expense.getId() +" Deleted!----------");
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
