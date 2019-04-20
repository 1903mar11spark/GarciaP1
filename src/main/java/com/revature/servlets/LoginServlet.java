package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.service.AuthService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthService as = new AuthService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check whether session exists, and create one if not
		// overloaded version takes a boolean parameter, if false returns null when there is none
		HttpSession session = request.getSession();
		//grab credentials from request
		
		Login log = new Login(request.getParameter("username"), request.getParameter("password"));
		//attempt to authenticate user
		String typeUser = as.isValidUser(log);
		
		
		if (typeUser != "") {
			switch (typeUser){
				case "ASSOCIATE":
					response.sendRedirect("dashboardAs");
					break;
				case "MANAGER":
					response.sendRedirect("dashboardMa");
					break;
				case "HR":
					response.sendRedirect("dashboardHR");
					break;
				default:
					PrintWriter pw = response.getWriter();
				pw.write("type of user is: " + typeUser);
					
					break;
			}	
		} else {
		 Enumeration<String> whole = request.getParameterNames();
			session.setAttribute("problem", "invalid credentials");
			PrintWriter pw = response.getWriter();
			
			while (whole.hasMoreElements()) {
				 
		            String paramName =whole.nextElement();
		            pw.write(paramName);
		            pw.write(":");
		 
		            String[] paramValues = request.getParameterValues(paramName);
		            for (int i = 0; i < paramValues.length; i++) {
		                String paramValue = paramValues[i];
		                pw.write(" " + paramValue);
		                pw.write(" ");
		                
		            }
		 
		        }
			pw.write(typeUser);
		}
	}

}