package iuh.dhktpm15b.dao;


import java.util.List;

import org.hibernate.*;

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
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			String sql = "select * from [dbo].[book]";
			List<Book> products = session
					.createNativeQuery(sql, Book.class)
					.getResultList();
			tr.commit();
			
			return products;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
		
	}
	
	public void read(int bookID) {
		Session session = sessionFactory.openSession();
		Book book = session.get(Book.class, bookID);

		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());

		session.close();
	}

	public boolean update(int bookID) {
		Book book = new Book(bookID);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Khoa Văn");
		book.setPrice(19.99f);
		Session session = sessionFactory.openSession();
		try {
			
			session.beginTransaction();

			session.update(book);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error while update book: " + e);
			return false;
		}
		

		
	}

	public boolean delete(int bookID) {
		Book book = new Book(bookID);
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.delete(book);

			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error while delete book: " + e);
			return false;
		}
		
	}
	
	
}
