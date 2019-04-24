package com.revature.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;


public class UpdateRService {

	public String updateRequest(String state, int rId) {
		String result = "";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENTS SET R_STATE = ? WHERE R_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,state);
			pstmt.setInt(2,rId);
			
			ResultSet rs= pstmt.executeQuery();
			result = "Employee was succesfully been updated";
		} catch (SQLException e) {
			result = "update failed";
			e.printStackTrace();
		}
		return result;
		
	}
}
