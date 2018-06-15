package com.yash.springpemapp.domain;

public class User {

	private Integer userId;
	private String name;
	private String phone;
	private String email;
	private String loginName;
	private String password;
	private Integer role;
	private Integer status;
	
	public User() {
		super();
	}
	
	public User(Integer userId, String name, String phone, String email, String loginName, String password,
			Integer role, Integer status) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
		this.status = status;
	}



	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", loginName="
				+ loginName + ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}
	
	
	
}
