package com.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 2016/03/23
 * author: Miao shan
 */

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable e) {
			System.err.println("SessionFactory creation failed" + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
