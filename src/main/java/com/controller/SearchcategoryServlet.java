package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchcategoryServlet")
public class SearchcategoryServlet extends HttpServlet{

		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		
		String userName = "root";
		String passWord = "admin";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
		
		
		try {
			Class.forName(driverClass);
			
			Connection conn = DriverManager.getConnection(connectionUrl, userName, passWord);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from products where category = ?");
			pstmt.setString(1, category);
			
			ResultSet rs = pstmt.executeQuery();
			
			request.setAttribute("rs", rs);
		
			request.getRequestDispatcher("OutputSearch.jsp").forward(request, response);
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
