package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursements;
import com.revature.service.RequestMService;


/**
 * Servlet implementation class RequestMServlet
 */
public class RequestMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestMService ra = new RequestMService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("RequestM.html").forward(request, response);
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
		System.out.println(eId);
		//int eId = (int) session.getAttribute("userId");
		int idE = Integer.parseInt(eId);
		Reimbursements reim = new Reimbursements(amount, desc, img, idE);
		String result = ra.requestM(reim);
		if(result !="") {
			response.sendRedirect("requestM");
		}else {
			//show alert employee was sucessfully been created
			response.sendRedirect("requestM");
		}
		
	}

}
