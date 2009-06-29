package com.skt.opensocial.persistence;


import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.User;

public class GadgetPublishTest {
	Logger logger = Logger.getLogger(GadgetPublishTest.class);
	private static String userId = "dev1";
	private static String adminId = "adm1";
	private static Long gadgetId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = new User();
		user.setId(userId);
		user.setRegisteredDate(new Date());
		user.setPassword("password");
		
		User admin = new User();
		admin.setId(adminId);
		admin.setRegisteredDate(new Date());
		admin.setPassword("password");
		admin.setIsAdministrator(true);
		
		session.saveOrUpdate(admin);
		session.saveOrUpdate(user);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		tran = session.beginTransaction();
		
		user = (User)session.load(User.class, userId);
		
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
		
		User user = (User)session.load(User.class, userId);
		User admin = (User)session.load(User.class, adminId);
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		
		session.delete(gadget);
		session.delete(user);
		session.delete(admin);
		
		
		tran.commit();
	}

	@Before
	public void setUp() throws Exception { // Create a Gadget

		
	}
	
	@Test
	public void requestPublish(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		
		GadgetPublish gp = new GadgetPublish();
		gp.setGadget(gadget);
		gp.setRequestedDate(new Date());
		
		session.save(gp);
		
		tran.commit();

	}
	

	@Test
	public void approvePublishRequest(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		GadgetPublish publishRequest = gadget.getGadgetPublish();
		publishRequest.setApprove(true);
		gadget.setPublishDate(new Date()); // disturbing code!
		
		session.saveOrUpdate(gadget);

		tran.commit();

	}
	@Test
	public void rejectPublishRequest(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		GadgetPublish publishRequest = gadget.getGadgetPublish();
		publishRequest.setApprove(false);
		gadget.setPublishDate(null); // disturbing code!
		
		session.saveOrUpdate(gadget);

		tran.commit();


	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
