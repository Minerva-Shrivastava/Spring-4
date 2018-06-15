package com.yash.springpemapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yash.springpemapp.dao.UserDAO;
import com.yash.springpemapp.domain.User;
import com.yash.springpemapp.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User user) {
		
		String sql = "INSERT INTO Users (name,phone,email,loginName,password) VALUES "
				+ "(:name, :phone, :email,:loginName, :password)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", user.getName());
		map.put("phone", user.getPhone());
		map.put("email", user.getEmail());
		map.put("loginName", user.getLoginName());
		map.put("password", user.getPassword());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(map);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);

		Integer userId = kh.getKey().intValue();
		System.out.println("User id is :" + userId);
		// user.setUserId(userId);

	}

	public void update(User user) {

		String sql = "UPDATE users SET " 
				+ "name = :name," 
				+ "phone = :phone," 
				+ "email = :email,"
				+ "loginName = :loginName,"
				+ "password = :password,"
				+ "role = :role,"
				+ "status = :status "
				+ " WHERE id = :userId";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", user.getName());
		map.put("phone", user.getPhone());
		map.put("email", user.getEmail());
		map.put("userId", user.getUserId());
		map.put("loginName", user.getLoginName());
		map.put("password", user.getPassword());
		map.put("role", user.getRole());
		map.put("status", user.getStatus());
		
		getNamedParameterJdbcTemplate().update(sql, map);

	}

	public void delete(User user) {
		
		this.delete(user.getUserId());

	}

	public void delete(Integer userId) {
		
		String sql = "delete from users where id = ?";
		getJdbcTemplate().update(sql, userId);

	}

	public User findById(Integer userId) {
		
		return getJdbcTemplate().queryForObject("SELECT * from users where id = ?", new UserRowMapper() , userId);
		
	}

	public List<User> findAll() {

		return getJdbcTemplate().query("SELECT * from users ", new UserRowMapper());
		
	}

	public List<User> findByProperty(String propertyName, Object propertyValue) {
		
		String sql = "SELECT * from users where "+propertyName+" =?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), propertyValue);
		
	}

	public User login(String loginName, String password) {
		User user = null;
		String sql = "SELECT * from users where loginName = ? && password = ?";
		Object[] params = new Object[] {loginName,password};
		try{
			user = getJdbcTemplate().queryForObject(sql, params, new UserRowMapper());
		}catch (EmptyResultDataAccessException e) {
			user = null;
		}
		return user;
	}

}
