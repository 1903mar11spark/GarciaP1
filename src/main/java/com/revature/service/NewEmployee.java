package com.revature.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.dao.CompanyDAO;
import com.revature.util.ConnectionUtil;

public class NewEmployee {

	public String setEmployee(Employee emp) {
		String result = "";
		//int employeeId = emp.getEmployeeId();
		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		String title = emp.getTitle();
		int subordinate = emp.getSubordinate();
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String dob = emp.getDob();
		String hireDate = emp.getHireDate();
		String city = emp.getCity();
		String state = emp.getState();
		String zip = emp.getZip();
		
			try (Connection con = ConnectionUtil.getConnection()) {
				String sql =  "INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, TITLE,SUBORDINATE, ADDRESS,PHONE, DOB,HIRE_DATE,CITY,STATE_E,ZIP)" + 
						" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,firstName);
				pstmt.setString(2,lastName);
				pstmt.setString(3,title);
				pstmt.setInt(4,subordinate);
				pstmt.setString(5,address);
				pstmt.setString(6,phone);
				pstmt.setString(7,dob);
				pstmt.setString(8,hireDate);
				pstmt.setString(9,city);
				pstmt.setString(10,state);
				pstmt.setString(11,zip);
				ResultSet rs= pstmt.executeQuery();
				result = "Employee was succesfully been created";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return result;
	}
	
}
