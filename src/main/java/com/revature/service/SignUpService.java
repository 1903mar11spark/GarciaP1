package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class SignUpService {
	
	public String idExists(int id, String username, String password) {
		String result = "";

		try (Connection con = ConnectionUtil.getConnection()) {
			
			String sql =  "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				int eId = rs.getInt("EMPLOYEE_ID");
				 if (id == eId) {
					result = addUser(id, username, password);
				 }else {
					result = "Employee Id is invalid please contact HR";
				 }
				//privilage ="the employee id is: " + eId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String addUser(int id, String username, String password) {
		String result = "";

		try (Connection con = ConnectionUtil.getConnection()) {
			
			String sql =  "INSERT INTO LOGIN (USER_ID, U_PASSWORD, EMPLOYEE_ID)" + 
					" VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setInt(3,id);
			ResultSet rs= pstmt.executeQuery();
			result = "user was succesfully been created";
		} catch (SQLException e) {
			result = "User was no created";
			e.printStackTrace();
		}
		return result;
		
	}

}
