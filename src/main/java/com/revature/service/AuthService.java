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

public class AuthService {

	public String isValidUser(Login log) {
		String privilage = "";
		String username = log.getUserId();
		String password = log.getPassword();
		if (username != null && password != null) {
			try (Connection con = ConnectionUtil.getConnection()) {
				String sql =  "SELECT * FROM LOGIN WHERE USER_ID = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,username);
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
					String rPass = rs.getString("U_PASSWORD");
					int eId = rs.getInt("EMPLOYEE_ID");
					if(password.equals(rPass)) {
						
						privilage = getPrivilage(eId);
					}
				
					//privilage ="the employee id is: " + eId;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return privilage;
	}
	public String getPrivilage(int eId) {
		String result ="";
		try (Connection con = ConnectionUtil.getConnection()) {
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,eId);
		ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
					result=rs.getString("TITLE");
					return result;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}