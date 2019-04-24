package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.UpdateRService;

/**
 * Servlet implementation class ManageRRH
 */
public class ManageRRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateRService urs = new UpdateRService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRRH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ManageHR.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String state = request.getParameter("rState");
		String rId = request.getParameter("rId");
		int idr = Integer.parseInt(rId);
		
		String eId = (String) session.getAttribute("userId");
		int idE = Integer.parseInt(eId);
		
		//System.out.println(idE);
		
		String result = urs.updateRequest(state, idr, idE);
		System.out.println(result);
		response.sendRedirect("manageHR");
	}

}
