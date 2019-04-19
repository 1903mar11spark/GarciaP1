package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.beans.Reimbursements;

import com.revature.util.ConnectionUtil;

import com.revature.dao.CompanyDAO;
import com.revature.dao.CompanyDAOImpl;

public class CompanyServiceImpl {
	private CompanyDAO bd = new CompanyDAOImpl();
	
	public boolean createEmployee(Employee emp) {
		return bd.createEmployee(emp);
	}

}
