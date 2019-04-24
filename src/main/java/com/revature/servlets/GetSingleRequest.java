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

/**
 * Servlet implementation class GetSingleRequest
 */
public class GetSingleRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetRequestA gra = new GetRequestA();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSingleRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	 Enumeration<String> whole = request.getParameterNames();
		PrintWriter pw = response.getWriter();
		
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
	 
	        }
		
    	if (session != null) {
    		try {
    			String rId = request.getParameter("reqId");
    				int idE = Integer.parseInt(rId);
    				//System.out.println(idE);
    				
    				Reimbursements requests = gra.getOneR(idE);
    				
    				response.getWriter().write((new ObjectMapper()).writeValueAsString(requests)); 
    				//System.out.println((new ObjectMapper()).writeValueAsString(requests));
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    				response.getWriter().write("Invalid request Id");
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
