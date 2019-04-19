package com.revature.beans;

public class Login {
	private String userId;
	private String password;
	private Employee employeeId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", password=" + password + ", employeeId=" + employeeId + "]";
	}
	public Login(String userId, String password, Employee employeeId) {
		super();
		this.userId = userId;
		this.password = password;
		this.employeeId = employeeId;
	}
	
	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	
}
