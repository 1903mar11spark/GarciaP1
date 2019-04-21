package com.revature.service;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;
import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.beans.Reimbursements;
import com.revature.dao.CompanyDAO;
import com.revature.util.ConnectionUtil;

public class RequestAService {

	public String requestA(Reimbursements reim) {
		String result ="";
		double rValue = reim.getrValue();
		String rDesc = reim.getrDesc();
		String rImg = reim.getrImg();//ask about this because its the blob
		int employeeId = reim.getEmployeeId();
		String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql =  "INSERT INTO REIMBURSEMENTS (R_VALUE, R_STATE, R_DESC, R_IMG, R_CREATION, EMPLOYEE_ID)" + 
					" VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1,rValue);
			pstmt.setString(2,rDesc);
			pstmt.setString(3,rImg);
			pstmt.setString(4,date);
			pstmt.setInt(5,employeeId);
			
			ResultSet rs= pstmt.executeQuery();
			result = "Request was succesfully been created";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
