package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet")

public class CalcServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		String Operation = request.getParameter("operation");
		
		
		if(no1 == null || no2==null || Operation==null)
		{
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.print("Please select all the fields");
		}
		
		else
		{
			int No1 = Integer.parseInt(no1);
			int No2 = Integer.parseInt(no2);
			
			int ans = 0;
			
			if(Operation.equals("+"))
			{
				ans = No1 + No2;
			}
			else if(Operation.equals("-"))
			{
				ans = No1 - No2;
			}
			else if(Operation.equals("*"))
			{
				ans = No1 * No2;
			}
			else
			{
				ans = No1 / No2;
			}
		
		
			response.setContentType("text/html");
		
			PrintWriter out = response.getWriter();
			out.print("ans = " + ans);
		
		}
	
	}

}
