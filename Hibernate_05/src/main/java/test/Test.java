package test;

import java.sql.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
//			Author author1 = new Author("001", "Nguyễn Nhật Ánh", new Date(System.currentTimeMillis()));
//			Book b1 = new Book("B01", "Cho tôi 1 vé đi tuổi thơ", 50000, author1);
//			Book b2 = new Book("B02", "Hoa vàng trên cỏ non", 75000, author1);
//			Book b3 = new Book("B03", "Đời hư ảo đưa em vào cơn phê", 60000, author1);
			
			Author author1 = new Author();
			author1.setAuthor_id("002");
			
			session.delete(author1);
			
//			session.saveOrUpdate(author1);
//			session.saveOrUpdate(b1);
//			session.saveOrUpdate(b2);
//			session.saveOrUpdate(b3);
			
//			Author author2 = new Author("002", "Nguyễn Đăng Duy", new Date(System.currentTimeMillis()));
//			Book b3 = new Book("B04", "Lập Trình Java", 100000, author2);
//			Book b4 = new Book("B05", "Toán rời rạc", 79000, author2);
//			Book b5 = new Book("B06", "Anh yêu em", 60000, author2);
//			
//			session.saveOrUpdate(author2);
//			session.saveOrUpdate(b3);
//			session.saveOrUpdate(b4);
//			session.saveOrUpdate(b5);
			
//			Book b1 = session.find(Book.class, "B05");
//			System.out.println("Tác giả của sách " + b1.getTitle() + " là " + b1.getAuthor().getName());
			
			
			tr.commit();
			session.close();
		}
	}
}
