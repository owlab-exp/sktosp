package com.skt.opensocial.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class GetFavoriteGadgetByUserIdTest {
	
	@Test
	public void getFavoriteGadget(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();

		String sampleUserName = "nash2";

		Criteria crit = s.createCriteria(Gadget.class)
							.createAlias("favoriteUsers", "user")
							//.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
							.add(Restrictions.eq("user.id", sampleUserName));
		// add order
		//crit.addOrder(Order.desc("user.id")); // or just "id" instead of "user.id"
		List l = crit.list();
		System.out.println(l.size());
		System.out.println(((Gadget)l.get(0)).getName());
		
//		List<User> friends = (List<User>) crit.list();
//
//		System.out.println("No. of friends=" + friends.size());
//		for (User u : friends)
//			System.out.println(u.getPerson().getName());

		t.commit();
		s.close();
		HibernateUtil.getSessionFactory().close();
	}

}
