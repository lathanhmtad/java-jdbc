package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	public static Connection getConnection()
	{
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Ontap;encrypt=true;trustServerCertificate=true";
			String username = "NDD";
			String password = "1234";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Có lỗi");
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try
		{
			if(c != null) {
				c.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		if(c != null) {
			try {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
}
