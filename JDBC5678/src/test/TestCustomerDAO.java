package test;

import java.util.ArrayList;

import dao.CustomerDAO;
import model.Customer;

public class TestCustomerDAO {
	public static void main(String[] args) {
		System.out.println("Kiểm tra");
		ArrayList<Customer> list = CustomerDAO.getInstance().selectAll();
		
		for (Customer customer : list) {
			System.out.println(customer.toString());
		}
	}
}
