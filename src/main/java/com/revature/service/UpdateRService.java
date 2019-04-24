package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


import java.util.Date;

import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;


public class UpdateRService {

	public String updateRequest(String state, int rId, int eId) {
		String result = "";
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENTS SET R_STATE = ? , R_AUTH_DATE = ? , AUTH_BY = ? WHERE R_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,state);
			pstmt.setString(2, date);
			pstmt.setInt(3,eId);
			pstmt.setInt(4,rId);
			
			ResultSet rs= pstmt.executeQuery();
			result = "Request was succesfully been updated";
		} catch (SQLException e) {
			result = "update failed";
			e.printStackTrace();
		}
		return result;
		
	}
}
