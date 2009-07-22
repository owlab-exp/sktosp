package com.skt.opensocial.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class GetFriendsTest {

	@Test
	public void getFriends() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();

		String sampleUserName = "john.doe";

		Criteria crit = s.createCriteria(User.class, "user")
							.createAlias("user.friendsByMe", "fm",CriteriaSpecification.LEFT_JOIN)
							.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
							.add(Restrictions
									.or(Restrictions.eq("fm.id", sampleUserName),Restrictions.eq("fo.id", sampleUserName)));
		// add order
		crit.addOrder(Order.desc("user.id")); // or just "id" instead of "user.id"
		
		
		List<User> friends = (List<User>) crit.list();

		System.out.println("No. of friends=" + friends.size());
		for (User u : friends)
			System.out.println(u.getPerson().getName());

		t.commit();
		s.close();
		HibernateUtil.getSessionFactory().close();
	}

}
