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

	public List<Reimbursements> getEmployeeId(int userId){
		List<Reimbursements> li = new ArrayList<Reimbursements>();
		List<Reimbursements> display = new ArrayList<Reimbursements>();
		//get the employee list
		//Reimbursements rem = new Reimbursements():
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE SUBORDINATE= ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				int eId = rs.getInt("EMPLOYEE_ID");
				//System.out.println(eId);
				li = getRequests(eId);
				display.addAll(li);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return display;
	}
	
	public Reimbursements getOneR(int rIde){
		Reimbursements rem = new Reimbursements();
		//System.out.println(rIde);
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,rIde);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				int rId = rs.getInt("R_ID");
				double value = rs.getDouble("R_VALUE");
				String state = rs.getString("R_STATE");
				String issued = rs.getString("R_CREATION");
				String desc = rs.getString("R_DESC");
				String img = "blob should go here";
				String auth = rs.getString("R_AUTH_DATE");
				int eId = rs.getInt("EMPLOYEE_ID");
				int aId = rs.getInt("AUTH_BY");
				//System.out.println(rId + " value: " + value + " state: " + state + " issued: " + issued + " auth: " + auth);
				rem = new Reimbursements (rId, value, state,desc, img, issued, auth, eId, aId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("statement faailed");
			e.printStackTrace();
		}
		
		
		return rem;
		
	}
}