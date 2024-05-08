package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat> {

	@Override
	public List<Cat> selectAll() {
		List<Cat> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL
				String hql = "from Cat";

				Query query = session.createQuery(hql);
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cat selectById(Cat t) {
		List<Cat> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL
				String hql = "from Cat c where c.id=:id";

				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				list = query.getResultList();
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (list.size() > 0) {
			return list.get(0);
		} else
			return null;
	}

	public boolean saveOrUpdate(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thuc thi cau lenh HQL

				// save when no exists
//				session.save(t);

				// save when no exists, update data when exists
				session.saveOrUpdate(t);

				tr.commit();

				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean insertT(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.delete(t);
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
