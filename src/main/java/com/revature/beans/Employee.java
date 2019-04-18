package com.revature.beans;

public class Employee {

	private int employeeId;
	private String firstName;
	private String LastName;
	private String title;
	private int subordinate;
	private String address;
	private String phone;
	private String dob;
	private String hireDate;
	private String city;
	private String country;
	
	//Getters and Setters
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSubordinate() {
		return subordinate;
	}
	public void setSubordinate(int subordinate) {
		this.subordinate = subordinate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", LastName=" + LastName + ", title="
				+ title + ", subordinate=" + subordinate + ", address=" + address + ", phone=" + phone + ", dob=" + dob
				+ ", hireDate=" + hireDate + ", city=" + city + ", country=" + country + "]";
	}
	
	
	//Constructors
	public Employee(int employeeId, String firstName, String lastName, String title, int subordinate, String address,
			String phone, String dob, String hireDate, String city, String country) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		LastName = lastName;
		this.title = title;
		this.subordinate = subordinate;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.hireDate = hireDate;
		this.city = city;
		this.country = country;
	}
	
	

}
