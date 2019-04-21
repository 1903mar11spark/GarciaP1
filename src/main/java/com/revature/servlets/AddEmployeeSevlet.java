package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.service.NewEmployee;

/**
 * Servlet implementation class NewEmployee
 */
public class AddEmployeeSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private NewEmployee ne = new NewEmployee();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addUser.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName =request.getParameter("lname");
		String title = request.getParameter("title");
		String subordinateTemp = request.getParameter("subordinate");
		int subordinate = Integer.parseInt(subordinateTemp);
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String hireDate = request.getParameter("hire");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Employee emp = new Employee(firstName,lastName,title,subordinate,address,phone,dob,hireDate,city,state,zip);
		String result = ne.setEmployee(emp);
		if(result !="") {
			response.sendRedirect("addEmployee");
		}else {
			//show alert employee was sucessfully been created
			response.sendRedirect("addEmployee");
		}
		
	}

}
