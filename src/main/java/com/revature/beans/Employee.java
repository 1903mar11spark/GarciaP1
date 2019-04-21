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
	private String state;
	private String zip;
	
	//Constructors
	
	public Employee(int employeeId, String firstName, String lastName, String title, int subordinate, String address,
			String phone, String dob, String hireDate, String city, String state, String zip) {
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
		this.state = state;
		this.zip = zip;
	}
	
	public Employee(String firstName, String lastName, String title, int subordinate, String address,
			String phone, String dob, String hireDate, String city, String state, String zip) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.title = title;
		this.subordinate = subordinate;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.hireDate = hireDate;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//toString

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", LastName=" + LastName + ", title="
				+ title + ", subordinate=" + subordinate + ", address=" + address + ", phone=" + phone + ", dob=" + dob
				+ ", hireDate=" + hireDate + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}




}
