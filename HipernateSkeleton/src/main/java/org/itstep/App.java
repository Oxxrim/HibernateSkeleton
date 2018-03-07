package org.itstep;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;
import org.itstep.util.HiberPropertiesUtil;
import org.itstep.util.HibernateUtil;

/**
 * 
 * @author Okhrumenko Dmytro
 *
 */
public class App {
	public static void main(String[] args) {

		HiberPropertiesUtil hUtil = new HiberPropertiesUtil();
		Account account = new Account("ignatenko220712", "123456", new Date(82, 7, 22).getTime(), "Alex", "Ignatenko");

		Session session = hUtil.configureSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(account);

		session.getTransaction().commit();

		session.close();

		Good good = new Good("BAJDHG52HG22", "Some name for test good", 12599);

		Session session1 = hUtil.configureSessionFactory().openSession();

		session1.getTransaction().begin();

		session1.save(good);

		session1.getTransaction().commit();

		session1.close();

		GoodAction goodAction = new GoodAction(System.currentTimeMillis(), "try to add to cart", Boolean.FALSE, account,
				good);

		Session session2 = hUtil.configureSessionFactory().openSession();

		session2.getTransaction().begin();

		session2.save(goodAction);

		session2.getTransaction().commit();

		session2.close();

		String sql = "SELECT account_login FROM good_actions WHERE time_action> :time";

		Session session3 = hUtil.configureSessionFactory().openSession();

		session3.getTransaction().begin();

		Query query = session3.createNativeQuery(sql).setParameter("time",
				Long.valueOf(System.currentTimeMillis() - (15 * 60 * 1000)));

		List<String> result = query.getResultList();

		session3.getTransaction().commit();

		session3.close();

		System.out.println(result.size());

		for (String string : result) {

			System.out.println(string);
		}

		System.out.println("Everything is done!");

	}
}
