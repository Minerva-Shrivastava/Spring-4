package com.yash.springpemapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.springpemapp.domain.Category;

public class CategoryRowMapper implements RowMapper<Category>{

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setUserId(rs.getInt("userId"));
		return category;
	}

}
