package com.yash.springpemapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yash.springpemapp.dao.CategoryDAO;
import com.yash.springpemapp.domain.Category;
import com.yash.springpemapp.rowmapper.CategoryRowMapper;

@Repository
public class CategoryDAOImpl extends BaseDAO implements CategoryDAO{

	public void save(Category category) {
	
		String sql = "INSERT INTO categories (name,userId) VALUES "
				+ "(:name, :userId)";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", category.getName());
		map.put("userId", category.getUserId());
		
		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(map);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);

		Integer categoryId = kh.getKey().intValue();
		System.out.println("User id is :" + categoryId);
		// user.setUserId(userId);

		
	}

	public void update(Category category) {
		
		String sql = "UPDATE categories SET " 
				+ "name = :name," 
				+ "userId = :userId " 
				+ "WHERE id = :categoryId";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", category.getName());
		map.put("userId", category.getUserId());
		map.put("categoryId", category.getId());

		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	public void delete(Category category) {
		
		this.delete(category.getId());
		
	}

	public void delete(Integer categoryId) {
		
		String sql = "delete from categories where id = ?";
		getJdbcTemplate().update(sql, categoryId);
		
	}

	public Category findById(Integer categoryId) {
	
		return getJdbcTemplate().queryForObject("SELECT * from categories where id = ?", new CategoryRowMapper() , categoryId);
		
	}

	public List<Category> findAll() {

		return getJdbcTemplate().query("SELECT * from categories ", new CategoryRowMapper());
		
	}

	public List<Category> findByProperty(String propertyName, Object propertyValue) {

		String sql = "SELECT * from categories where "+propertyName+" =?";
		return getJdbcTemplate().query(sql, new CategoryRowMapper(), propertyValue);

	}

}
