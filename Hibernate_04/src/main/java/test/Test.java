package test;

import java.sql.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			
//			Person p1 = new Person("Nguyễn Văn A", new Date(System.currentTimeMillis()), null);
//			session.save(p1);
			
			//Person p1 = session.find(Person.class, 2L);
			//Person p2 = new Person("Nguyễn Thị C", new Date(System.currentTimeMillis()), p1);
			//session.save(p2);

			Person p1 = session.find(Person.class, 2L);
			Person p2 = session.find(Person.class, 5L);
			
			System.out.println(p1.getName());
			System.out.println(p2.getName());
			
			session.saveOrUpdate(p1); // Persistent state
			
			p1.setName("Duy");
			

			
			tr.commit(); 
			session.close();
		}
	}
}
