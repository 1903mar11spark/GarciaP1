package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.beans.Reimbursements;
import com.revature.service.GetRequestA;

/**
 * Servlet implementation class DashboardAs
 */
public class DashboardAs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetRequestA gra = new GetRequestA();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardAs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession(true);
		String eId = (String) session.getAttribute("userId");
		System.out.println((String) session.getAttribute("userId"));
	if (session != null) {
		try {
				int idE = Integer.parseInt(eId);
				List<Reimbursements> requests =  gra.getRequests(idE);
				request.setAttribute("requests", requests);
				
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(requests);
				
				
				response.setContentType("application/json;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache"); 
				PrintWriter out = response.getWriter();
				out.print(jsonString);
				
				System.out.println(jsonString);
				//request.getRequestDispatcher("Dashboard-Associate.html").forward(request, response);
				//out.flush();
				//request.getRequestDispatcher("requests.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
		response.getWriter().write("{\"session\":null}");
		}
		request.getRequestDispatcher("Dashboard-Associate.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("requestA");
	}

}
