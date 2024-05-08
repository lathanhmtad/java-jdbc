package test;

import java.util.ArrayList;

import dao.BookDAO;
import model.Book;

public class TestBookDAO {
	public static void main(String[] args) { 
		ArrayList<Book> list = BookDAO.getInstance().selectAll();
		for (Book book : list) {
			System.out.println(book.toString());
		}
		
		Book find = new Book();
		find.setId("002");
		Book book2 = BookDAO.getInstance().selecById(find);
		
		System.out.println("Tìm sách có id 001: " + book2.toString());
		
		
		
		System.out.println("--------------");
		ArrayList<Book> list2 = BookDAO.getInstance().selectByCondition("price < 120000");
		for (Book book : list2) {
			System.out.println(book.toString());
		}
	}
}
