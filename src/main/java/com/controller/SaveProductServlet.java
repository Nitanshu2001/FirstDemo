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

@WebServlet("/SaveProductServlet")
public class SaveProductServlet extends HttpServlet{
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read Data First
		
		String productName = request.getParameter("productName");
		Integer price =	Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		Integer qty = Integer.parseInt(request.getParameter("qty"));
		
		//Validation >> Filter 1
		
		
		// DB Insert
		
		String userName = "root";
		String password = "admin";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
		
		
		try {
			Class.forName(driverClass);
			
			
			Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
			
			PreparedStatement pstmt = conn.prepareStatement("insert into products(productName,price,category,qty)values(?,?,?,?)");
			
			pstmt.setString(1, productName);
			pstmt.setInt(2, price);
			pstmt.setString(3, category);
			pstmt.setInt(4, qty);
			
			
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
				
	}

	
	
}
