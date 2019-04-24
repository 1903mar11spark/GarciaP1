package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class DeleteEmployeeService {

	public String DeleteEmployee(int eid) {
		String result = "";
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + eid; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			result = "Employee was succesfully been erased";
		} catch (SQLException e) {
			result = "Employee still exists";
			e.printStackTrace();
		}
		return result;
			
	}
}
