package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection1 {

		private static String userName = "root";
		private static String passWord = "admin";
		private static String driverClass = "com.mysql.cj.jdbc.Driver";
		private static String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";


	public static Connection getDBConnection()
	{
		Connection conn = null;
		try {
			Class.forName(driverClass);
			
			
			conn = DriverManager.getConnection(connectionUrl, userName, passWord); 
			
			
			if(conn != null)
			{
				System.out.println("Connected....");
			}
			else
			{
				System.out.println("Not Connected..");
			}
			
			
			
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
		
	public static void main(String[] args)
	{
		DBConnection1.getDBConnection();
	}



}