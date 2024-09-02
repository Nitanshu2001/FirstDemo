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

public class SaveProductServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Data Read
		
		String productName = request.getParameter("productName");
		Integer price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		Integer qty = Integer.parseInt(request.getParameter("qty"));
		
		
		//Validate is in Filter.
		
		
		//DB Insert.
		
		try {
			
			//loading driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Open DB Connectiom 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Nitanshu", "root", "admin");
			
			//query >> run >> PreparedStatement
			
			PreparedStatement pstmt = conn.prepareStatement("insert into products(productName,price,category,qty) values(?,?,?,?)");
			
			pstmt.setString(1, productName);
			pstmt.setInt(2, price);
			pstmt.setString(3, category);
			pstmt.setInt(4, qty);
			
			// run >> execute >> update
			
			pstmt.executeUpdate();
			
			System.out.println("Product added Successfully..");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
