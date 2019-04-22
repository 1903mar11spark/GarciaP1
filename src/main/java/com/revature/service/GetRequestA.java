package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;

public class GetRequestA {
	

	public List<Reimbursements> getRequests(int userId){
		List<Reimbursements> li = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				int rId = rs.getInt("R_ID");
				double value = rs.getDouble("R_VALUE");
				String state = rs.getString("R_STATE");
				String issued = rs.getString("R_CREATION");
				String auth = rs.getString("R_AUTH_DATE");
				li.add(new Reimbursements (rId, value, state, issued, auth));
				//System.out.println(rId + " value: " + value + " state: " + state + " issued: " + issued + " auth: " + auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return li;
		
	}

}
