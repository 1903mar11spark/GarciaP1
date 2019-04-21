package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardHR
 */
public class DashboardHR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardHR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Dashboard-HR.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
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
			
		switch(act) {
		case "add":
			response.sendRedirect("addEmployee");
			break;
		case "update":
			break;
		case "delete":
			break;
		default:
			
			break;
		}
		doGet(request, response);
	}

}
