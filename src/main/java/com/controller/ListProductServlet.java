package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet{
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = "root";
		String passWord = "admin";
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
		
		
		try {
			Class.forName(driverClass);
			
			Connection conn = DriverManager.getConnection(connectionUrl, userName, passWord);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from products");
			
			ResultSet rs = pstmt.executeQuery();
			
			request.setAttribute("rs", rs);
			
			request.getRequestDispatcher("ListUser.jsp").forward(request, response);
			
			
//			This is for to get data on console screen.
			
//			while(rs.next())
//			{
//						
//				String productName = rs.getString("productName");
//				int price = rs.getInt("price");
//				String category = rs.getString("category");
//				int qty = rs.getInt("qty");
//				
//				
//				System.out.println(productName+" "+price+" "+category+" "+qty);
//			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
