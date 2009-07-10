package com.skt.opensocial.persistence;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class QueryTest {
	Logger logger = Logger.getLogger(QueryTest.class);
	private static String userId = "samson";
	private static String friendId = "lion";
	private static Long aGadgetId;
	private static Long bGadgetId;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception { // Create a User for Test
		
	}
	
	@Test
	public void SearchUserByPerson(){
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();
		
		Criteria crit = hs.createCriteria(Person.class);
		crit.add(Restrictions.like("nameFormatted", "%"));
		//
//		User u = new User();
//		u.getPerson().getNameFormatted();
		//
		List list = crit.list();
		
		logger.info("list size="+ list.size());
		
		
		for(Object o: list) {
			Person p = (Person)o;
			User u = p.getUser();
			if(u != null)
			logger.info("User ID=" + u.getId());
		}
		tran.commit();
	}
	
	@Test
	public void listGadgets(){
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();
		
		Criteria crit = hs.createCriteria(Gadget.class);
		crit.addOrder(Order.desc("id"));
		crit.setFirstResult(1);
		crit.setMaxResults(5);
		
		List list = crit.list();
		
		logger.info("list size="+ list.size());
		
		
		for(Object o: list) {
			Gadget g = (Gadget)o;
			if(g != null)
			logger.info("Gadget ID=" + g.getName());
		}
		tran.commit();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
