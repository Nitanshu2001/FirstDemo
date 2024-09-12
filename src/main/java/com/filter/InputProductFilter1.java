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
public class InputProductFilter1 implements Filter{

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter1...");
		
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String qty = request.getParameter("qty");
		
		
		boolean isError = false;
		
		
		
		if(productName == null || productName.trim().length() == 0 )
		{
			isError = true;
			request.setAttribute("productNameError", "Please Enter Product Name.");
		}
//		else
//		{
//			String alphaRegex = "[a-zA-Z]+";
//			if(productName.matches(alphaRegex) == false)
//				{
//					isError = true;
//					request.setAttribute("productNameError", "Alphabetic Name Only..");
//				}	
//		}
		
		
		
		if(price == null || price.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("priceError", "Please Enter Price.");	
		}
		else
		{
			try
			{
				Integer priceint = Integer.parseInt(price);
				if(priceint < 0)
				{
					isError = true;
					request.setAttribute("priceError", "Price must be greater than Zero..");
				}		
			}
			catch(NumberFormatException e)
			{
				isError = true;
				request.setAttribute("priceError", "Price must be integer only..");
			}
			
		}
		
		
		if(category == null || category.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("categoryError", "Please enter category");
		}
		else
		{
			String alphaRegex = "[a-zA-Z]+";
			if(category.matches(alphaRegex) == false)
				{
					isError = true;
					request.setAttribute("categoryError", "Alphabetic Name Only..");
				}	
		}
		
		
		
		

		
		if(qty == null || qty.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("qtyError", "Please enter qty.");
		}
		else
		{
			try
			{
				Integer qtyint = Integer.parseInt(qty);
				if(qtyint < 0)
				{
					isError = true;
					request.setAttribute("qtyError", "Qty must be greater than 0.");
				}
			}
			catch(NumberFormatException e)
				{
					isError = true;
					request.setAttribute("qtyError", "Qty must be integer only..");
				}
		}
		
		
	
		if(isError == true)
		{
			request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	
	

}
