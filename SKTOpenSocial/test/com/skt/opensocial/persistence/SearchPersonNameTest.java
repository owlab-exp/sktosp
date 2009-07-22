package com.skt.opensocial.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class SearchPersonNameTest {

	@Test
	public void getFriends() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();

		String sampleUserName = "john";

		Criteria crit = s.createCriteria(User.class)
		.createAlias("person", "p")
		.add(Restrictions.like("p.nameFormatted", sampleUserName));
		crit.list();
		
		
//		List<User> user = (List<User>) crit.list();
//
//		System.out.println("No. of friends=" + user.size());
//		for (User u : user)
//			System.out.println(u.getPerson().getName());

		t.commit();
		s.close();
		HibernateUtil.getSessionFactory().close();
	}

}
