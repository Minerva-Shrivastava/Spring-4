package com.yash.springpemapp.domain;

public class Category {

	private Integer id;
	private String name;
	private Integer userId;
	
	public Category() {
		super();
	}
	
	
	public Category(Integer id, String name, Integer userId) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", userId=" + userId + "]";
	}
	
	
}
