package test;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO dao = new CatDAO();
		
		// Test selectAll
//		List<Cat> list = dao.selectAll();
//		
//		for (Cat cat : list) {
//			System.out.println(cat);
//		}
		
		Cat c3 = new Cat();
		c3.setId(2);
		
		System.out.println(dao.delete(c3));
	}
}
