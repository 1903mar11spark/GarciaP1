package com.revature.dao;

import java.util.*;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.beans.Reimbursements;

public interface CompanyDAO {
	public boolean createEmployee(Employee emp);
	public String isvalidUser(Login log);
}
