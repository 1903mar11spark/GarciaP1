package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;

public class GetEmployeeService {
	
	public Employee getSingleEmployee(int rIde){
		Employee emp = new Employee();
		//System.out.println(rIde);
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,rIde);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				String title = rs.getString("TITLE");
				int subordinate = rs.getInt("SUBORDINATE");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String dob = rs.getString("DOB");
				String hire = rs.getString("HIRE_DATE");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE_E");
				String zip = rs.getString("ZIP");
				emp = new Employee(rIde, fName,lName,title, subordinate,address, phone, dob, hire, city, state, zip);
				//System.out.println(fName + " " +lName + " " + title + " " + subordinate + " " + address + " " + phone + " " + dob + " " +  hire + " " + city + " " + state + " " + zip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("statement failed");
			e.printStackTrace();
		}
		
		
		return emp;
		
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> emp = new ArrayList<Employee>();
		//System.out.println(rIde);
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			while (rs.next()) {
				int eId = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				String title = rs.getString("TITLE");
				int subordinate = rs.getInt("SUBORDINATE");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String dob = rs.getString("DOB");
				String hire = rs.getString("HIRE_DATE");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE_E");
				String zip = rs.getString("ZIP");
				emp.add(new Employee(eId,fName,lName,title, subordinate,address, phone, dob, hire, city, state, zip));
				//System.out.println(fName + " " +lName + " " + title + " " + subordinate + " " + address + " " + phone + " " + dob + " " +  hire + " " + city + " " + state + " " + zip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Request failed");
			e.printStackTrace();
		}
		
		
		return emp;
		
	}


}
