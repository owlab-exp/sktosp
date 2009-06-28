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

import com.skt.opensocial.persistence.Activity;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.util.HibernateUtil;

public class ActivityAddListDeleteTest {
	Logger logger = Logger.getLogger(ActivityAddListDeleteTest.class);
	private static String userId = "wife";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		if(user == null) {
			user = new User();
			user.setId(userId);
		}
		user.setRegisteredDate(new Date());
		user.setPassword("password");
		
		session.saveOrUpdate(user);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		user = (User)session.load(User.class, userId);
		
		Person person = new Person();
		person.setUser(user);
		person.setNameFormatted("An activitist");
		
		session.saveOrUpdate(person);
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
	public void addActivity(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		//User user = (User)session.load(User.class, userId);
		Person person = (Person)session.load(Person.class, userId);
		
		Activity act1 = new Activity();
		act1.setPerson(person);
		act1.setActivityId(""+System.currentTimeMillis());
		act1.setTitle("Sample Title1");
		
		session.saveOrUpdate(act1);
		
		Activity act2 = new Activity();
		act2.setPerson(person);
		act2.setActivityId(""+System.currentTimeMillis());
		act2.setTitle("Sample Title2");
		
		session.saveOrUpdate(act2);
		
		//gadgetId = g.getId();
		
		tran.commit();

	}
	

	@Test
	public void listActivities(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person)session.load(Person.class, userId);
		
		Collection<Activity> as = person.getActivities();
		
		assertEquals("Number of activities", 2, as.size());
		
		for(Activity g: as) {
			logger.log(Level.INFO, g.getTitle());
		}

		tran.commit();

	}

	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
