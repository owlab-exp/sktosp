package com.skt.opensocial.persistence;


import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.User;

public class GadgetAddListDeleteTest {
	Logger logger = Logger.getLogger(GadgetAddListDeleteTest.class);
	private static String userId = "dev1";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = new User();
		user.setId(userId);
		user.setRegisteredDate(new Date());
		user.setPassword("password");
		
		session.saveOrUpdate(user);
		tran.commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User)session.load(User.class, userId);
		session.delete(user);
		
		tran.commit();
	}

	@Before
	public void setUp() throws Exception { // Create a User for Test
		
	}
	
	@Test
	public void addGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User)session.load(User.class, userId);
		
		Gadget g = new Gadget();
		g.setName("Sample Gadget");
		g.setRegisterDate(new Date());
		g.setSource("AAAAAAAAAA");
		g.setStatus("pd");
		g.setDeveloper(user);
		
		session.saveOrUpdate(g);
		
		Gadget g1 = new Gadget();
		g1.setName("Sample Gadget");
		g1.setRegisterDate(new Date());
		g1.setSource("AAAAAAAAAA");
		g1.setStatus("pd");
		g1.setDeveloper(user);
		
		session.saveOrUpdate(g1);
		
		//gadgetId = g.getId();
		
		tran.commit();

	}
	

	@Test
	public void listGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User)session.load(User.class, userId);
		
		Collection<Gadget> gs = user.getGadgets();
		
		//assertEquals("Number of gadgets", 2, gs.size());
		
		for(Gadget g: gs) {
			logger.log(Level.INFO, g.getName());
			logger.log(Level.INFO, g.getRegisterDate());
			logger.log(Level.INFO, g.getSource());
			logger.log(Level.INFO, g.getStatus());
			logger.log(Level.INFO, g.getDeveloper().getId());
		}

		tran.commit();

	}
	@Test
	public void deleteGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User)session.load(User.class, userId);
		
		Collection<Gadget> gs = user.getGadgets();
		
		//assertEquals("Number of gadgets", 2, gs.size());
		
		for(Gadget g: gs) {
			session.delete(g);
		}
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		user = (User)session.load(User.class, userId);
		
		gs = user.getGadgets();
		assertEquals("Gadget se", 0, gs.size());
		
		tran.commit();
		

	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
