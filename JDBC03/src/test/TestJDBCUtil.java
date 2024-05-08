package test;

import java.sql.Connection;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		
		JDBCUtil.printInfo(conn);
		
		JDBCUtil.closeConnection(conn);
		
//		System.out.println(conn);
	}
}
