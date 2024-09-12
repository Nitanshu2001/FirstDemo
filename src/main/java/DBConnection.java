import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private static String userName = "root";
	private static String passWord = "admin";
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static String connectionUrl = "jdbc:mysql://localhost:3306/Nitanshu";
			
	
	
	public static Connection getDBConncetion()
	{
		Connection conn = null;
		//loading driver class
		try {
			Class.forName(driverClass);
			
			 conn = DriverManager.getConnection(connectionUrl, userName, passWord);
			
			 
			 if(conn != null)
			 {
				 System.out.println("Database Connected...");
			 }
			 else
			 {
				 System.out.println("Connection Failed..");
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
		DBConnection.getDBConncetion();
		
	}
	
			
}