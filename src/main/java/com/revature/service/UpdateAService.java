package com.revature.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class UpdateAService {
	
	public String updateEmployee(Employee emp) {
		
		String result = "";
		int eId = emp.getEmployeeId();
		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String dob = emp.getDob();
		String city = emp.getCity();
		String state = emp.getState();
		String zip = emp.getZip();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE EMPLOYEE SET FIRST_NAME =?, LAST_NAME = ?, ADDRESS=?"
					+ " ,PHONE = ?, DOB = ?,CITY = ? ,STATE_E = ? ,ZIP = ? WHERE EMPLOYEE_ID = " + eId + ")"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,address);
			pstmt.setString(4,phone);
			pstmt.setString(5,dob);
			pstmt.setString(6,city);
			pstmt.setString(7,state);
			pstmt.setString(8,zip);
			ResultSet rs= pstmt.executeQuery();
			result = "Employee was succesfully been created";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
