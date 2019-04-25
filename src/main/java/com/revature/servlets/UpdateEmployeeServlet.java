package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.service.UpdateAService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UpdateAService uAS = new  UpdateAService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("UpdateEmployee.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String idE = (String) session.getAttribute("userId");
		int eId = Integer.parseInt(idE);
		String firstName = request.getParameter("fname");
		String lastName =request.getParameter("lname");
		String title = request.getParameter("title");
		String subordinate = request.getParameter("subordinate");
		int sub= Integer.parseInt(subordinate);
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String hire = request.getParameter("hire");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Employee emp = new Employee(eId,firstName,lastName,title,sub, address,phone,dob,hire, city,state,zip);
		String result = uAS.updateEmployee(emp);
		response.sendRedirect("updateEmployee");
	}

}
