package test;

import java.sql.Connection;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			// Bước 1: Tạo kết nối
			Connection conn = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi một câu lệnh sql
			String sql = "INSERT INTO Persons(person_id, last_name, first_name, gender, dob, income)"
					+ " VALUES('001', N'C', N'Trần Thị', 1, '20000510', 550000)";
			
			System.out.println("Kiểm tra");
			
			int check = st.executeUpdate(sql);
			
			System.out.println("Chạy");
			
			// Bước 4: xử lí kết quả
			System.out.println("Số dòng thay đổi: " + check);
			if(check > 0) {
				System.out.println("Thêm dữ liệu thành công!");
			}
			else
			{
				System.out.println("Thêm dữ liệu thất bại!");
			}
			
			// Bước 5: ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
