package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AllHtmlInputServlet")

public class AllHtmlInputServlet extends HttpServlet {
		
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		
		String firstname = request.getParameter("firstname");
		
		
		if(firstname == null || firstname.trim().length() == 0)
		{
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.print("Please enter FirstName.");
			
		} // end of if
		
		
		else
		{
			String birthyear = request.getParameter("birthyear");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String city =  request.getParameter("city");
			String address = request.getParameter("address");
			
			String hobby[] = request.getParameterValues("hobby");
		
		
		
			response.setContentType("text/html");
		
			PrintWriter out = response.getWriter();
		
		
		
			out.print("Firstname: " +firstname+ "<br>");
			out.print("Birthyear: " +birthyear+ "<br>");
			out.print("Email: " +email+ "<br>");
			out.print("Passsword: " +password+ "<br>");
			out.print("Gender: " +gender+ "<br>");
			out.print("City: " +city+ "<br>");
			out.print("Address: " +address+ "<br>");
			out.print("Hobby: ");
			
			for(int i=0;i<hobby.length;i++)
			{
				out.print(hobby[i]+" ");
			}
			
		}// end of else
			
	}// end of service 
	
} //end of class
