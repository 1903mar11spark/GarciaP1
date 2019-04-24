package com.revature.beans;

public class Reimbursements {
	private int rId;
	private double rValue;
	private String rState;
	private String rDesc;
	private String rImg;//ask about this because its the blob
	private int employeeId;
	private String issued;
	private String authDate;
	private int auth;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public double getrValue() {
		return rValue;
	}
	public void setrValue(double rValue) {
		this.rValue = rValue;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}
	public String getrDesc() {
		return rDesc;
	}
	public void setrDesc(String rDesc) {
		this.rDesc = rDesc;
	}
	public String getrImg() {
		return rImg;
	}
	public void setrImg(String rImg) {
		this.rImg = rImg;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	
	public String getIssued() {
		return issued;
	}
	public void setIssued(String issued) {
		this.issued = issued;
	}
	public String getAuthDate() {
		return authDate;
	}
	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}

	
	@Override
	public String toString() {
		return "Reimbursements [rId=" + rId + ", rValue=" + rValue + ", rState=" + rState + ", rDesc=" + rDesc
				+ ", rImg=" + rImg + ", employeeId=" + employeeId + ", issued=" + issued + ", authDate=" + authDate
				+ ", auth=" + auth + "]";
	}
	public Reimbursements(int rId, double rValue, String rState, String rDesc, String rImg, int employeeId,
			int auth) {
		super();
		this.rId = rId;
		this.rValue = rValue;
		this.rState = rState;
		this.rDesc = rDesc;
		this.rImg = rImg;
		this.employeeId = employeeId;
		this.auth = auth;
	}
	
	public Reimbursements(double rValue, String rDesc, String rImg, int employeeId) {
		super();
		this.rValue = rValue;
		this.rDesc = rDesc;
		this.rImg = rImg;
		this.employeeId = employeeId;
	}
	public Reimbursements(int rId, double rValue, String rState, String issued, String authDate) {
		super();
		this.rId = rId;
		this.rValue = rValue;
		this.rState = rState;
		this.issued = issued;
		this.authDate = authDate;
	}
	public Reimbursements() {
		// TODO Auto-generated constructor stub
	}
	public Reimbursements(int rId, double rValue, String rState, String rDesc, String rImg, String issued, String authDate,
			int eId, int auth) {
		this.rId = rId;
		this.rValue = rValue;
		this.rState = rState;
		this.rDesc = rDesc;
		this.rImg = rImg;
		this.issued = issued;
		this.authDate = authDate;
		this.employeeId = eId;
		this.auth = auth;
	}
	
	
	  
}
