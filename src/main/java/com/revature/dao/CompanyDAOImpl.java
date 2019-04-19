package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.beans.Reimbursements;

import com.revature.util.ConnectionUtil;

public class CompanyDAOImpl implements CompanyDAO{
	
	@Override
	public boolean createEmployee(Employee emp) {
		boolean success = false;
		
		if(emp !=null) {
			try (Connection con = ConnectionUtil.getConnection()) {

				String sql = "INSERT INTO EMLOYEE (FIRST_NAME, LAST_NAME, TITLE, SUBORDINATE, ADDRESS, PHONE, DOB, "
						+ "HIRE_DATE, CITY, STATE_E, ZIP) VALUES (?, ?, ?, ?, ? ,? ,? , ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,emp.getFirstName());
				pstmt.setString(2,emp.getLastName());
				pstmt.setString(3,emp.getTitle());
				pstmt.setInt(4,emp.getSubordinate());
				pstmt.setString(5,emp.getAddress());
				pstmt.setString(6, emp.getPhone());
				pstmt.setDate(7, Date.valueOf(emp.getDob()));
				pstmt.setDate(8, Date.valueOf(emp.getHireDate()));
				pstmt.setString(9, emp.getCity());
				pstmt.setString(10, emp.getState());
				pstmt.setString(11, emp.getZip());
				if (pstmt.executeUpdate() > 0) {
					success = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			//} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		return success;
	}
	

}
