package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursements;
import com.revature.service.GetRequestA;
import com.revature.service.RequestAService;
import com.revature.service.UpdateRService;

/**
 * Servlet implementation class GetPendingM
 */
public class GetPendingM extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetRequestA gra = new GetRequestA();
    UpdateRService urs = new UpdateRService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPendingM() {
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
    			//System.out.println((String) session.getAttribute("userId"));
    				int idE = Integer.parseInt(eId);
    				List<Reimbursements> requests =  gra.getEmployeeId(idE);
    				
    				response.getWriter().write((new ObjectMapper()).writeValueAsString(requests)); 
    				//System.out.println((new ObjectMapper()).writeValueAsString(requests));
    				
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
		doGet(request, response);
	}
}

