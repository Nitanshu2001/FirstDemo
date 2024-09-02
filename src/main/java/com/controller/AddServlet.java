package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Number1 = request.getParameter("number1");
		String Number2 = request.getParameter("number2");
		
		int num1 = Integer.parseInt(Number1);
		int num2 = Integer.parseInt(Number2);
		
		int total = num1+num2;
		
		
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
			out.print("<h2>Addition<h2>");
			out.print("<br>Total:"+total);
		}
		
	}
	
}
