package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursements;
import com.revature.service.GetEmployeeAService;

/**
 * Servlet implementation class getEmployeeA
 */
public class GetEmployeeAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private GetEmployeeAService geas = new GetEmployeeAService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
	    
				if (session != null) {
						try {
							String eId = (String) session.getAttribute("userId");
							System.out.println((String) session.getAttribute("userId"));
							int idE = Integer.parseInt(eId);
							Employee emp  =  geas.getEmployeeA(idE);
    				
							response.getWriter().write((new ObjectMapper()).writeValueAsString(emp)); 
							System.out.println((new ObjectMapper()).writeValueAsString(emp));
    				
						} catch (Exception e) {
							e.printStackTrace();
							response.getWriter().write("{\"session\":null}");
						}
				} else {
					response.getWriter().write("{\"session\":null}");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
