package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read Data First
		
		String productName = request.getParameter("productName");
		String price =	request.getParameter("price");
		String category = request.getParameter("category");
		String qty = request.getParameter("qty");
		
		//Validation >> Filter 1
		
		
		// DB Insert
		
		String userName = "root";
		String password = "admin";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
		
		
		try {
			Class.forName(driverClass);
			
			
			Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
			
			PreparedStatement pstmt = conn.prepareStatement("Delete from products where productName = ?");
			
			pstmt.setString(1, productName);
			
			int rs = pstmt.executeUpdate();
			
			System.out.println(rs+ " rows affected");
			
			
						
		} catch (Exception e) {
			e.printStackTrace();
		} 
				
	}

	
	
}
