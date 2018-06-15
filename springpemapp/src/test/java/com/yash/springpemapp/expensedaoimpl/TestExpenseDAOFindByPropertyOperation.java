package com.yash.springpemapp.expensedaoimpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.springpemapp.configuration.SpringRootConfig;
import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;

public class TestExpenseDAOFindByPropertyOperation {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ExpenseDAO expenseDAO = ctx.getBean(ExpenseDAO.class);
		
		List<Expense> expenses = expenseDAO.findByProperty("categoryId", "4");
		
		for (Expense expense : expenses) {
			System.out.println(expense);
		}
		
		((ConfigurableApplicationContext)ctx).close();
		
	}
}
