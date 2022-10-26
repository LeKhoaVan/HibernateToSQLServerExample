package iuh.dhktpm15b.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import iuh.dhktpm15b.entity.Book;
import iuh.dhktpm15b.util.HibernateUtil;

public class BookDAO {
	private SessionFactory sessionFactory;
	
	public BookDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public BookDAO() {
		this.sessionFactory = new HibernateUtil().getSessionFactory();
	}
	
	
	
	public boolean addBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.save(book);
			transaction.commit();
			return true;
		} catch(Exception e) {
			transaction.rollback();
			System.out.println("Error save: "+ e);
			return false;
		}
		
	}
	
	public List<Book> getBook() {
		Session session = sessionFactory.openSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from SinhVien";
			List<Book> books = session
					.createQuery(sql, Book.class)
					.getResultList();
			
			tr.commit();
			return books;
			
		} catch (Exception e) {
			tr.rollback();
		}
		
		session.close();
		
		return null;
	}
}
