package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class GetEmployeeAService {
	
	public Employee getEmployeeA(int eId) {
		Employee emp = new Employee();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,eId);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String dob = rs.getString("DOB");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE_E");
				String zip = rs.getString("ZIP");
				emp = new Employee(fName,lName,address, phone, dob, city, state, zip);
				//System.out.println(rId + " value: " + value + " state: " + state + " issued: " + issued + " auth: " + auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		
	}

}
