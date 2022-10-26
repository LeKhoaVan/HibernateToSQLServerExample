package iuh.dhktpm15b.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import iuh.dhktpm15b.entity.Book;



public class HibernateUtil {
	private SessionFactory sessionFactory;
	
	public HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()//hibernate.cfg.xml
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Book.class)
				.getMetadataBuilder().build();
		
		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
		sessionFactory.close();
	}
}	
