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
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.User;

public class GadgetReviewTest {
	Logger logger = Logger.getLogger(GadgetReviewTest.class);
	private static String userId = "dev1";
	private static String reviewerId = "rev1";
	private static Long gadgetId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = new User();
		user.setId(userId);
		user.setRegisteredDate(new Date());
		user.setPassword("password");
		
		User reviewer = new User();
		reviewer.setId(reviewerId);
		reviewer.setRegisteredDate(new Date());
		reviewer.setPassword("password");
		
		session.saveOrUpdate(reviewer);
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
		User reviewer = (User)session.load(User.class, reviewerId);
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		
		session.delete(gadget);
		session.delete(user);
		session.delete(reviewer);
		
		
		tran.commit();
	}

	@Before
	public void setUp() throws Exception { // Create a Gadget
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tran = session.beginTransaction();
//		
//		User user = (User)session.load(User.class, userId);
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
	public void addReview(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User reviewer = (User)session.load(User.class, reviewerId);
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		
		GadgetReview gr = new GadgetReview(reviewer, gadget);
		gr.setReviewDate(new Date());
		gr.setReviewGrade(10);
		gr.setReviewText("Prominence");
				
		session.save(gr);
		
		tran.commit();

	}
	

	@Test
	public void listReviews(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
		Collection<GadgetReview> reviewsFromGadget = gadget.getReviews();
		
		assertEquals("Number of reviews", 1, reviewsFromGadget.size());
		
		User reviewer = (User)session.load(User.class, reviewerId);
		Collection<GadgetReview> reviewsFromReviewer = gadget.getReviews();
		
		assertEquals("Number of reviews", 1, reviewsFromReviewer.size());
		

		tran.commit();

	}
	@Test
	public void deleteReviews(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User reviewer = (User)session.load(User.class, reviewerId);
		
		Collection<GadgetReview> gr = reviewer.getReviews();
		
		for(GadgetReview g: gr) {
			session.delete(g);
		}
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		reviewer = (User)session.load(User.class, reviewerId);
		
		gr = reviewer.getReviews();
		assertEquals("Gadget se", 0, gr.size());
		
		tran.commit();
		

	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
