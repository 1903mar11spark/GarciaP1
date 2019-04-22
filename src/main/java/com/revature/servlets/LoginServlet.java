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
       
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check whether session exists, and create one if not
		// overloaded version takes a boolean parameter, if false returns null when there is none
		HttpSession session = request.getSession();
		//grab credentials from request
		
		Login log = new Login(request.getParameter("username"), request.getParameter("password"));
		//attempt to authenticate user
		String typeUser = as.isValidUser(log);
		String uId = as.getUserId(log);
		session.setAttribute("userId", uId);
		session.setAttribute("typeUser", typeUser);
		if (typeUser != "") {
			switch (typeUser){
				case "Associate":
					System.out.println((String) session.getAttribute("userId"));
					response.sendRedirect("dashboardAs");
					break;
				case "Manager":
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
		
			session.setAttribute("problem", "invalid credentials");
			response.sendRedirect("login");
			/*//this was to check the parameter names and if was getting correctly the user input
			 Enumeration<String> whole = request.getParameterNames();
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
			pw.write(typeUser);*/
		}
	}

}