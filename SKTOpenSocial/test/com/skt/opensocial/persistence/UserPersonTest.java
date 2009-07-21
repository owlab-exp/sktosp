package com.skt.opensocial.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class UserPersonTest {
	private static String userId = "nash";
	@Test
	public void getPerson() {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		
		User user = (User) sess.load(User.class, userId);
		user.getPerson();
		//sess.evict(user);
		//sess.flush();
		
		tx.commit();
		//sess.close();
		
		System.out.println(user.getPerson().getName() + ": " + user.getClass().getName() );
	}

}
