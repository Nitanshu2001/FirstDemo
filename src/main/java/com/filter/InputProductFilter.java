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

@WebFilter("/SaveProductServlet")
public class InputProductFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter1..");
		
		String productName = request.getParameter("productName");
		
		String price = request.getParameter("price");
		
		String category = request.getParameter("category");
		
		String qty = request.getParameter("qty");
		
		boolean isError = false;
		
		
		
		if(productName == null || productName.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("productNameError", "Please enter the Name.");
		}
		
		if(price == null || price.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("priceError", "Please enter the price.");
		}
		
		if(category == null || category.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("categoryError", "Category cannt be empty.");
		}
		
		if(qty == null || qty.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("qtyError", "Please enter the qty.");
		}
	
		
		
		if(isError == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("InputProduct.jsp");
			rd.forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		
	}
		
		
		
	

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
