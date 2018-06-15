package com.yash.springpemapp.domain;

import java.sql.Date;

public class Expense {

	private Integer id;
	private Integer categoryId;
	private float amount;
	private Date date;
	private String remark;
	
	public Expense() {
		super();
	}
	
	
	public Expense(Integer id, Integer categoryId, float amount, Date date, String remark) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.amount = amount;
		this.date = date;
		this.remark = remark;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", categoryId=" + categoryId + ", amount=" + amount + ", date=" + date
				+ ", remark=" + remark + "]";
	}
	
	
	
}
