package main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectSQLServer {
	// Create name database
	private static final String DBNAME = "Bookstore";

	// JDBC driver name and database URL
	private static final Driver JDBC_DRIVER = new SQLServerDriver();
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true";

	// Database credentials
	private static final String USERNAME = "NDD";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			// STEP 2: Register JDBC driver
//			Class.forName(JDBC_DRIVER);
			DriverManager.registerDriver(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connection to database ...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Connection!");
			e.printStackTrace();
		}
		return conn;
	}

}