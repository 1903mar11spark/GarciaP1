package com.revature.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.util.ConnectionUtil;

public class AuthService {

	public Login isValidUser(Login log) {
		Login u = null;
		String username = log.getUserId();
		String password = log.getPassword();
		if (username != null && password != null) {
			try (Connection con = ConnectionUtil.getConnection()) {

				String sql = "SELECT USER_ID, U_PASSWORD, EMPLOYEE_ID FROM LOGIN WHERE USER_ID=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,username);
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
					String rPass = rs.getString("U_PASSWORD");
					int eId = rs.getInt("EMPLOYEE_ID");
					
					if(password.equals(rPass)) {
						u = new Login(username, password);
						
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
		
	}

}