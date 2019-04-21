package com.revature.beans;

public class Session {
	int employeeId;
	String typeUser;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	@Override
	public String toString() {
		return "Session [employeeId=" + employeeId + ", typeUser=" + typeUser + "]";
	}
	public Session(int employeeId, String typeUser) {
		super();
		this.employeeId = employeeId;
		this.typeUser = typeUser;
	}
	
	

}
