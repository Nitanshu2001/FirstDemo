package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoxCricketRegistrationServlet")
public class BoxCricketRegistrationServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("BoxCricketRegistrationServlet::service()");
		
		RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistrationSuccess.jsp");
		rd.forward(request, response);
		
		/*
		 String playerName = request.getParameter("playerName");
		 
		String playerType = request.getParameter("playerType");
		
		boolean isError = false;
		
		if(playerName == null || playerName.trim().length() == 0)
		{
			request.setAttribute("playerNameError", "Please enter Player Name");
			isError = true;
		}
		
		if(playerType == null || playerType.trim().length() == 0)
		{
			request.setAttribute("playerTypeError", "Please Select any skill");
			isError = true;
		}
		
		if(isError == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistration.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistrationSuccess.jsp");
			rd.forward(request, response);
		}
		*/
		
		
	}
	

}
