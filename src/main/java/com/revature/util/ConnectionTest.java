package com.revature.util;

import java.text.SimpleDateFormat;
import java.util.*;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.dao.CompanyDAO;
import com.revature.dao.CompanyDAOImpl;
import com.revature.service.AuthService;
import com.revature.service.NewEmployee;


public class ConnectionTest {
	
	public static void main(String [] args) {
		
		screen();
	}

	public static void screen() {
		AuthService bd = new AuthService();
		NewEmployee ne = new NewEmployee();
		String result="";
		//CompanyDAO bd2 = new CompanyDAOImpl();
		
	/*	Scanner uInput = new Scanner(System.in);
		System.out.println("Welcome, please input your user name: ");
		String user = uInput.nextLine();
		System.out.println("Please input your password: ");
		String pass = uInput.nextLine();
		String exists;
		Login log = new Login(user,pass);
		exists = bd.isValidUser(log);
		if(exists.equals("HR")) {
			System.out.println(exists);
		}else {
			System.out.println(exists);
		}
		uInput.close();*/
		Employee em = new Employee("Xigbar","Freeshoter", "Manager", 7, "1535 Radiant Garden ave.","(657)569 6688", "02/15/1996","12/12/13","Tampa", "FL","78423");
		result=ne.setEmployee(em);
		System.out.println(result);
	}

}