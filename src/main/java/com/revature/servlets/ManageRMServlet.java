package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.UpdateRService;

/**
 * Servlet implementation class ManageRMServlet
 */
public class ManageRMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateRService urs = new UpdateRService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ManageM.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> whole = request.getParameterNames();
		/*PrintWriter pw = response.getWriter();

		while (whole.hasMoreElements()) {
			 
		        String paramName =whole.nextElement();
		        pw.write(paramName);
		        pw.write(":");
		        
		        String[] paramValues = request.getParameterValues(paramName);
		        for (int i = 0; i < paramValues.length; i++) {
		            String paramValue = paramValues[i];
		            System.out.println(" "+ paramValue);
		            pw.write(" " + paramValue);
		            pw.write(" ");
		            
		        }

		    }*/
				String state = request.getParameter("rState");
				int rId = 21;
				String result = urs.updateRequest(state, rId);
				System.out.println(result);
				response.sendRedirect("manageRM");
			}
	}

