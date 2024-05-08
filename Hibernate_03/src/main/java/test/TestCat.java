package test;

import java.sql.Date;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO dao = new CatDAO();
		
		Cat c3 = new Cat();
		c3.setId(1);
		
		System.out.println(dao.selectById(c3));
	}
}
