package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {

	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}
	
	@Override
	public int insert(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Customer> res = new ArrayList<Customer>();
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = conn.createStatement();
			
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM Customer";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			// Bước 4:
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				Date date = rs.getDate("dob");
				String address = rs.getString("address");
				
				Customer c = new Customer(id, name, date, address);
				res.add(c);
				
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
	public Customer selecById(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
