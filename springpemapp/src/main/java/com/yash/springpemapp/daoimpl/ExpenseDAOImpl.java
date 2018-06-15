package com.yash.springpemapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yash.springpemapp.dao.ExpenseDAO;
import com.yash.springpemapp.domain.Expense;
import com.yash.springpemapp.rowmapper.ExpenseRowMapper;

@Repository
public class ExpenseDAOImpl extends BaseDAO implements ExpenseDAO{

	public void save(Expense expense) {
		
		String sql = "INSERT INTO expenses (categoryId,amount,date,remark) VALUES "
				+ "(:categoryId, :amount, :date,:remark)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryId", expense.getCategoryId());
		map.put("amount", expense.getAmount());
		map.put("date", expense.getDate());
		map.put("remark", expense.getRemark());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(map);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);

		Integer expenseId = kh.getKey().intValue();
		
		System.out.println("Expense id is :" + expenseId);
		// user.setUserId(userId);
		
	}

	public void update(Expense expense) {
		
		String sql = "UPDATE expenses SET " 
				+ "categoryId = :categoryId," 
				+ "amount = :amount," 
				+ "date = :date,"
				+ "remark = :remark "
				+ " WHERE id = :expenseId";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("categoryId", expense.getCategoryId());
		map.put("amount", expense.getAmount());
		map.put("date", expense.getDate());
		map.put("remark", expense.getRemark());
		map.put("expenseId", expense.getId());

		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	public void delete(Expense expense) {
		
		this.delete(expense.getId());
		
	}

	public void delete(Integer expenseId) {

		String sql = "delete from expenses where id = ?";
		getJdbcTemplate().update(sql, expenseId);

	}

	public Expense findById(Integer expenseId) {

		return getJdbcTemplate().queryForObject("SELECT * from expenses where id = ?", new ExpenseRowMapper() , expenseId);
		
	}

	public List<Expense> findAll() {

		return getJdbcTemplate().query("SELECT * from expenses ", new ExpenseRowMapper());
		
	}

	public List<Expense> findByProperty(String propertyName, Object propertyValue) {

		String sql = "SELECT * from expenses where "+propertyName+" =?";
		return getJdbcTemplate().query(sql, new ExpenseRowMapper(), propertyValue);
		
	}

}
