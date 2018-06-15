package com.yash.springpemapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.springpemapp.domain.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setLoginName(rs.getString("loginName"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("role"));
		user.setStatus(rs.getInt("status"));
		return user;
	}

}
