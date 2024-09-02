package com.utill	;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "root";
	private static String password = "admin";
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
	
	
	
	
	public static Connection getDBConnection()
	{
		Connection conn = null;
		//loading driver class...
		try {
			Class.forName(driverClass);
			
		// getting connection with DB..
			
			conn = DriverManager.getConnection(connectionUrl, userName, password);
			
			if(conn != null)
			{
				System.out.println("Connected with Database.....");
			}
			
			else
			{
				System.out.println("Not Connected..");
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	
	
	public static void main(String[] args)
	{
		DBConnection.getDBConnection();
	}
}
