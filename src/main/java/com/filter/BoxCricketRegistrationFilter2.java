package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/BoxCricketRegistrationServlet")
public class BoxCricketRegistrationFilter2 implements Filter{
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("BoxCricketRegistrationFilter2");
		
		
		String playerName = request.getParameter("playerName");
		
		String alphaRegex = "[a-zA-Z]+";
		
		Boolean isError = false;
		
		if(playerName.matches(alphaRegex) == false)
		{
			isError = true;
			request.setAttribute("playerNameError", "Please enter valid firstName");
		}
		
		if(isError == true)
		{
			request.getRequestDispatcher("BoxCricketRegistration.jsp").forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
	}

	
	public void destroy() {
		
		
	}
}
