package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursements;
import com.revature.service.RequestAService;

/**
 * Servlet implementation class RequestHRServlet
 */
public class RequestHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RequestAService ra = new RequestAService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("RequestHR.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountS = request.getParameter("amount");
		double amount = Double.parseDouble(amountS);
		String desc =request.getParameter("desc");
		String img2 = request.getParameter("inputRecipt");
		String img = "C:\\Project1\\GarciaP1\\src\\main\\webapp\\Styles\\" + img2;
		HttpSession session = request.getSession(true);
		String eId = (String) session.getAttribute("userId");
		int idE = Integer.parseInt(eId);
		Reimbursements reim = new Reimbursements(amount, desc, img, idE);
		String result = ra.requestA(reim);
		System.out.println(result);
		if(result !="") {
			response.sendRedirect("requestHR");
		}else {
			//show alert employee was sucessfully been created
			response.sendRedirect("requestHR");
	}
	}
}
