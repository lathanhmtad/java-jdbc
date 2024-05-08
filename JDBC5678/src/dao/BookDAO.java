package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Book;

public class BookDAO implements DAOInterface<Book> {

	public static BookDAO getInstance() {
		return new BookDAO();
	}
	
	@Override
	public int insert(Book t) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO Book" + " VALUES('" + t.getId() + "', N'" + t.getName() + "', " + t.getPrice() + ", " + t.getPublishingYear() + ")";
			
			
			
			res = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + res + "dòng bị thay đổi");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Book t) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "UPDATE Book"
					+ " SET id = '" + t.getId() + "', name = '" + t.getName() + "', price = " + t.getPrice() + ", publishingYear = " + t.getPublishingYear()
					+ " WHERE id = '" + t.getId() + "'";
			
			
			res = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + res + "dòng bị thay đổi");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(Book t) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "DELETE FROM Book WHERE publishingYear = " + t.getPublishingYear();
			
			
			res = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + res + "dòng bị thay đổi");
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Book> res = new ArrayList<Book>();
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM Book";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			// Bước 4:
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int year = rs.getInt("publishingYear");
				
				Book book = new Book(id, name, price, year);
				res.add(book);
				
			}
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Book selecById(Book t) {
		// TODO Auto-generated method stub
		Book res = null;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM Book WHERE id = '" + t.getId() + "'";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			// Bước 4:
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int year = rs.getInt("publishingYear");
				
				res = new Book(id, name, price, year);
				
			}
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ArrayList<Book> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<Book> res = new ArrayList<Book>();
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM Book WHERE " + condition;
			
			ResultSet rs = st.executeQuery(sql);
			
			
			// Bước 4:
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int year = rs.getInt("publishingYear");
				
				Book book = new Book(id, name, price, year);
				res.add(book);
				
			}
			
			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
