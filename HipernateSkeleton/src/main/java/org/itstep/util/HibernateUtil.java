package org.itstep.util;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() throws HibernateException {
		sessionFactory = configureSessionFactory();
	}

	/**
	 * Создание фабрики
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory() throws HibernateException {
		String userDir = System.getProperty("user.dir");

		Configuration configuration = new Configuration().configure(new File(userDir + "/src/main/resources/hibernate.cfg.xml"));
		return configuration.buildSessionFactory();

	}

	/**
	 * Получить фабрику сессий
	 * 
	 * @return {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}