package com.skt.opensocial.persistence;


import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.util.HibernateUtil;

public class GadgetCategoryTest {
	Logger logger = Logger.getLogger(GadgetCategoryTest.class);
	private static String developerId = "dev1";
	private static String userId = "usr1";
	private static Long gadgetId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = new User();
		user.setId(developerId);
		user.setRegisteredDate(new Date());
		user.setPassword("password");
		
//		User reviewer = new User();
//		reviewer.setId(userId);
//		reviewer.setRegisteredDate(new Date());
//		reviewer.setPassword("password");
//		
//		session.saveOrUpdate(reviewer);
		session.saveOrUpdate(user);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		tran = session.beginTransaction();
		
		user = (User)session.load(User.class, developerId);
		
		Gadget g = new Gadget();
		g.setName("Sample Gadget");
		g.setRegisterDate(new Date());
		g.setSource("AAAAAAAAAA");
		g.setStatus("pd");
		g.setDeveloper(user);
		
		gadgetId = (Long) session.save(g);
		
		tran.commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User developer = (User)session.load(User.class, developerId);
		//User user = (User)session.load(User.class, userId);
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		
		session.delete(gadget);
		session.delete(developer);
		//session.delete(user);
		
		
		tran.commit();
	}

	@Before
	public void setUp() throws Exception { // Create a Gadget
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tran = session.beginTransaction();
//		
//		User user = (User)session.load(User.class, developerId);
//		
//		Gadget g = new Gadget();
//		g.setName("Sample Gadget");
//		g.setRegisterDate(new Date());
//		g.setSource("AAAAAAAAAA");
//		g.setStatus("pd");
//		g.setDeveloper(user);
//		
//		gadgetId = (Long) session.save(g);
//		
//		tran.commit();
		
	}
	
	@Test
	public void addCategories(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		Set<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
		GadgetCategory category1 = (GadgetCategory) session.load(GadgetCategory.class, "dating");
		GadgetCategory category2 = (GadgetCategory) session.load(GadgetCategory.class, "communication");
		categorySet.add(category1);
		categorySet.add(category2);
		gadget.setCategories(categorySet);
				
		session.saveOrUpdate(gadget);
		
		tran.commit();

	}
	

	@Test
	public void changeCategories(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		Set<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
		GadgetCategory category1 = (GadgetCategory) session.load(GadgetCategory.class, "lifestyle");
		GadgetCategory category2 = (GadgetCategory) session.load(GadgetCategory.class, "sports");
		categorySet.add(category1);
		categorySet.add(category2);
		gadget.setCategories(categorySet);
				
		session.saveOrUpdate(gadget);
		
		tran.commit();

	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
