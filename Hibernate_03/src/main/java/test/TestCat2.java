package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat2 {
	public static void main(String[] args) {
		
		// transient
		Cat c = new Cat();
		c.setFullname("Meo Long Xu");
		c.setDateOfBirth(new Date(System.currentTimeMillis()));
		c.setSex(true);
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				// persistent
				session.save(c);

				tr.commit();
				
				// detached => persistent
				session.refresh(c);
				
				
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c);
	}
}
