package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/SaveProductServlet")
public class InputProductFilter2 implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter2..");
		
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String qty = request.getParameter("qty");
		boolean isError = false;
		
		
		String alphaRegex = "[a-zA-Z]+";
		String numericRegex = "\\d+";
		
		
		
		if(productName.matches(alphaRegex) == false)
		{
			isError = true;
			request.setAttribute("productNameError", "Alphabetic Name Only..");
		}
		
		
		
		//if((price+"").matches(numericRegex) == false)
		if(price.matches(numericRegex) == false)
		{
			isError = true;
			request.setAttribute("priceError", "Numeric Values Only..");
		}
		else {
            try {
                Integer.parseInt(price); // Safe parsing
            } catch (NumberFormatException e) {
                isError = true;
                request.setAttribute("priceError", "Invalid numeric value for price..");
            }
        } 
		
		
		
		if(category.matches(alphaRegex) == false)
		{
			isError = true;
			request.setAttribute("categoryError", "Alphabetic Name Only..");
		}
		
		
		
		if(qty.matches(numericRegex) == false)
		{
			isError = true;
			request.setAttribute("qtyError", "Numeric Values Only..");
		}
		else {
            try {
                Integer.parseInt(qty); // Safe parsing
            } catch (NumberFormatException e) {
                isError = true;
                request.setAttribute("qtyError", "numeric values only..");
            }
        }
		
		
		
		if(isError == true)
		{
			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
		}
		else
		{
			chain.doFilter(request,response);	
			
		}
		
}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	

}
