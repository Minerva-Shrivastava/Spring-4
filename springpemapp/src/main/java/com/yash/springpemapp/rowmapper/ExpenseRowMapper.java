package com.yash.springpemapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.springpemapp.domain.Expense;

public class ExpenseRowMapper implements RowMapper<Expense>{

	public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
		Expense expense = new Expense();
		expense.setId(rs.getInt("id"));
		expense.setCategoryId(rs.getInt("categoryId"));
		expense.setAmount(rs.getFloat("amount"));
		expense.setDate(rs.getDate("date"));
		expense.setRemark(rs.getString("remark"));
		return expense;
	}

}
