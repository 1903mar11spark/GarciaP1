package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.RequestAService;
import com.revature.beans.Reimbursements;

/**
 * Servlet implementation class RequestA
 */
public class RequestA extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestAService ra = new RequestAService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("RequestA.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountS = request.getParameter("amount");
		double amount = Double.parseDouble(amountS);
		String desc =request.getParameter("desc");
		String img = request.getParameter("inputRecipt");
		Reimbursements reim = new Reimbursements(amount, desc, img, );
		String result = ra.requestA(reim);
		if(result !="") {
			response.sendRedirect("addEmployee");
		}else {
			//show alert employee was sucessfully been created
			response.sendRedirect("addEmployee");
		}
	}

}
