package com.skt.opensocial.persistence;


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


public class DatabaseInitializeTask {
	Logger logger = Logger.getLogger(DatabaseInitializeTask.class);
	private static String userId = "nash";
	
	//private static String friendId = "friend1";
	

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
	public void addCategories(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new GadgetCategory("communication","커뮤니케이션"));
		session.saveOrUpdate(new GadgetCategory("dating","데이트"));
		session.saveOrUpdate(new GadgetCategory("events","이벤트"));
		session.saveOrUpdate(new GadgetCategory("finance","경제"));
		session.saveOrUpdate(new GadgetCategory("food_and_drinks","음식"));
		session.saveOrUpdate(new GadgetCategory("games_and_fun","재미와 게임"));
		session.saveOrUpdate(new GadgetCategory("lifestyle","라이프 스타일"));
		session.saveOrUpdate(new GadgetCategory("movies_and_tv","영화와 TV"));
		session.saveOrUpdate(new GadgetCategory("music","음악"));
		session.saveOrUpdate(new GadgetCategory("news","뉴스"));
		session.saveOrUpdate(new GadgetCategory("politics","정치"));
		session.saveOrUpdate(new GadgetCategory("sports","스포츠"));
		session.saveOrUpdate(new GadgetCategory("tools","도구"));
		session.saveOrUpdate(new GadgetCategory("travel","여행"));
		session.saveOrUpdate(new GadgetCategory("video","비디오"));
		
		session.getTransaction().commit();
	}
	@Test
	public void addUser(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		if(user == null) {
			user = new User();
			user.setId(userId);
		}
		user.setRegisteredDate(new Date());
		user.setPassword("nash");
		user.setIsAdministrator(true);
		user.setIsDeveloper(true);
		
		session.saveOrUpdate(user);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		Person person = (Person) session.get(Person.class, userId);
		if(person == null) {
			person = new Person();
			//person.setId(userId);
			person.setUser(user);
		}
		person.setNameFormatted("NASH 팀");
		person.setAboutme("Sample Test 사용자");
		
		session.saveOrUpdate(person);
		tran.commit();

	}
	
	@Test
	public void addGadget(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		
		// add first gadget
		Gadget gadget = new Gadget();
		gadget.setDeveloper(user);
		gadget.setName("To do");
		gadget.setRegisterDate(new Date());
		gadget.setIconUrl("icon url sample");
		gadget.setIntroduction("This is sample todo gadget");
		gadget.setRegisterType("url");
		gadget.setStatus("rg");
		gadget.setSource("http://www.labpixies.com/campaigns/todo/todo.xml");
		gadget.setRegisterDate(new Date());
		
		Set<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
		GadgetCategory category1 = (GadgetCategory)session.load(GadgetCategory.class, "dating");
		GadgetCategory category2 = (GadgetCategory)session.load(GadgetCategory.class, "communication");
		categorySet.add(category1);
		categorySet.add(category2);
		
		gadget.setCategories(categorySet);
	
		session.saveOrUpdate(gadget);
		
		// add second gadget
		Gadget anotherGadget = new Gadget();
		anotherGadget.setDeveloper(user);
		anotherGadget.setName("Social Activities");
		anotherGadget.setRegisterDate(new Date());
		anotherGadget.setIconUrl("icon url sample");
		anotherGadget.setIntroduction("This is another sample gadget");
		anotherGadget.setRegisterType("url");
		anotherGadget.setStatus("rg");
		anotherGadget.setSource("http://localhost:8080/gadgets/files/samplecontainer/examples/SocialActivitiesWorld.xml");
		anotherGadget.setRegisterDate(new Date());
		
		Set<GadgetCategory> categorySet2 = new HashSet<GadgetCategory>();
		GadgetCategory category11 = (GadgetCategory)session.load(GadgetCategory.class, "sports");
		GadgetCategory category12 = (GadgetCategory)session.load(GadgetCategory.class, "travel");
		categorySet2.add(category11);
		categorySet2.add(category12);
		
		anotherGadget.setCategories(categorySet2);
		
		session.saveOrUpdate(anotherGadget);
		tran.commit();

	}
	
	
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
