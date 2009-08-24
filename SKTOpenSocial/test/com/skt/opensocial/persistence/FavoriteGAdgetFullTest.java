package com.skt.opensocial.persistence;


import static org.junit.Assert.assertEquals;

import java.util.Collection;
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
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.security.PasswordEncryptor;

public class FavoriteGAdgetFullTest {
	Logger logger = Logger.getLogger(FavoriteGAdgetFullTest.class);
	private static String developerId = "dev1";
	private static String userId = "usr1";
	private static Long gadgetId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tran = session.beginTransaction();
//		
//		User user = new User();
//		user.setId(developerId);
//		user.setRegisteredDate(new Date());
//		user.setPassword("password");
//		
//		User reviewer = new User();
//		reviewer.setId(userId);
//		reviewer.setRegisteredDate(new Date());
//		reviewer.setPassword("password");
//		
//		session.saveOrUpdate(reviewer);
//		session.saveOrUpdate(user);
//		tran.commit();
//		
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		tran = session.beginTransaction();
//		
//		user = (User)session.load(User.class, developerId);
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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tran = session.beginTransaction();
//		
//		User developer = (User)session.load(User.class, developerId);
//		User user = (User)session.load(User.class, userId);
//		Gadget gadget = (Gadget)session.load(Gadget.class, gadgetId);
//		
//		session.delete(gadget);
//		session.delete(developer);
//		session.delete(user);
//		
//		
//		tran.commit();
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
	public void addUsers(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		// add or create one user
		User user = (User) session.get(User.class, userId);
		if(user == null) {
			user = new User();
			user.setId(userId);
		}
		user.setRegisteredDate(new Date());
		user.setPassword(PasswordEncryptor.getInstance().encrypt("123456"));
		user.setIsAdministrator(true);
		user.setIsDeveloper(true);
		
		session.saveOrUpdate(user);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		Person person = (Person) session.get(Person.class, userId);
		if(person == null) {
			person = new Person();
			person.setUser(user);
		}
		person.setNameFormatted("ASamSon");
		person.setAboutme("Sample Test 사용자");
		person.setAge(18);
		
		session.saveOrUpdate(person);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		UserVisibility userVisible = (UserVisibility) session.get(UserVisibility.class, userId);
		if(userVisible == null) {
			userVisible = new UserVisibility();
			userVisible.setUser(user);
		}
		userVisible.setName("그럭저럭");
		
		session.saveOrUpdate(userVisible);
		tran.commit();
		
		// add or create another user
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		User developer = (User) session.get(User.class, developerId);
		if(developer == null) {
			developer = new User();
			developer.setId(developerId);
		}
		developer.setRegisteredDate(new Date());
		developer.setPassword(PasswordEncryptor.getInstance().encrypt("123456"));
		developer.setIsAdministrator(true);
		developer.setIsDeveloper(true);
		
		session.saveOrUpdate(developer);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		Person developerPerson = (Person) session.get(Person.class, developerId);
		if(developerPerson == null) {
			developerPerson = new Person();
			developerPerson.setUser(developer);
		}
		developerPerson.setNameFormatted("A Lion");
		developerPerson.setAboutme("Sample Test 사자");
		developerPerson.setAge(18);
		
		session.saveOrUpdate(developerPerson);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		UserVisibility developerVisi = (UserVisibility) session.get(UserVisibility.class, developerId);
		if(developerVisi == null) {
			developerVisi = new UserVisibility();
			developerVisi.setUser(developer);
		}
		developerVisi.setName("그럭저럭");
		
		session.saveOrUpdate(developerVisi);
		tran.commit();

	}
	
	@Test
	public void addGadget(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User developer = (User)session.get(User.class, developerId);
		
		Gadget g = new Gadget();
		g.setName("Sample Gadget");
		g.setRegisterDate(new Date());
		g.setSource("AAAAAAAAAA");
		g.setStatus("pd");
		g.setDeveloper(developer);
		
		gadgetId = (Long) session.save(g);

		
		GadgetPublish gp = new GadgetPublish();
		gp.setGadget(g);
		
		session.saveOrUpdate(gp);
		
		GadgetIcon gi = new GadgetIcon();
		gi.setGadget(g);
		
		session.saveOrUpdate(gi);
		
		tran.commit();

	}
	
	@Test
	public void addFavoriteGadget(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		//User user = (User)session.get(User.class, userId);
		User user = (User)session.get(User.class, developerId);
		Gadget gadget = (Gadget)session.get(Gadget.class, gadgetId);
		
		Set<Gadget> gadgets = user.getFavoriteGadgets();
		if(gadgets == null)
			gadgets = new HashSet<Gadget>();
		gadgets.add(gadget);
		
				
		session.saveOrUpdate(user);
		
		tran.commit();

	}
	

	@Test
	public void listFavoriteGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		//User user = (User) session.get(User.class, userId);
		User user = (User) session.get(User.class, developerId);
		Collection<Gadget> gadgets = user.getFavoriteGadgets();
		
//		assertEquals("Number of gadgets", 1, gadgets.size());
		
//		User reviewer = (User)session.load(User.class, userId);
//		Collection<Gadget> reviewsFromReviewer = gadget.getReviews();
//		
//		assertEquals("Number of reviews", 1, reviewsFromReviewer.size());
		

		tran.commit();

	}
	@Test
	public void deleteFavoriteGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		//User user = (User)session.get(User.class, userId);
		User user = (User)session.get(User.class, developerId);
		Gadget gadget = (Gadget) session.get(Gadget.class, gadgetId);
		
		user.removeFavoriteGadget(gadget);
		
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		//user = (User)session.get(User.class, userId);
		user = (User)session.get(User.class, developerId);
		
		
		Set<Gadget> gs = user.getFavoriteGadgets();
		assertEquals("Gadget set", 0, gs.size());
		
		tran.commit();
		

	}
	
	@Test
	public void deleteGadget(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget g = (Gadget)session.get(Gadget.class, gadgetId);
		
		session.delete(g);
		
		tran.commit();

	}
	
	@Test
	public void deleteUsers(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		// add or create one user
		User user = (User) session.get(User.class, userId);
		
		User developer = (User) session.get(User.class, developerId);
		
		session.delete(user);
		session.delete(developer);
		
		tran.commit();

	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
