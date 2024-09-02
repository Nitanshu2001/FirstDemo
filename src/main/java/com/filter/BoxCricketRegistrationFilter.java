package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/BoxCricketRegistrationServlet")
public class BoxCricketRegistrationFilter implements Filter {
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
	
		System.out.println("BoxCricketRegistrationFilter::init()");

		
	}
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
			System.out.println("BoxCricketRegistrationFilter::doFilter()");
			
			Boolean isError = false;
			
			String playerName = request.getParameter("playerName");
			String playerType = request.getParameter("playerType");
			
			if(playerName == null || playerName.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("playerNameError", "Please enter Player Name");
			}
			
			if(playerType == null || playerType.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("playerTypeError", "Please select Player Type");

			}
			
			
			if(isError == true)
			{
				RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistration.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				chain.doFilter(request, response);
			}
			
		
	}
	
	
	
	public void destroy() {
		
		System.out.println("BoxCricketRegistrationFilter::destroy()");

	}

}
