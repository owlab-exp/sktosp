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

import com.skt.opensocial.security.PasswordEncryptor;


public class UserFriendTest {
	Logger logger = Logger.getLogger(UserFriendTest.class);
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
	public void addUser(){
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
		
		User friend = (User) session.get(User.class, friendId);
		if(friend == null) {
			friend = new User();
			friend.setId(friendId);
		}
		friend.setRegisteredDate(new Date());
		friend.setPassword(PasswordEncryptor.getInstance().encrypt("123456"));
		friend.setIsAdministrator(true);
		friend.setIsDeveloper(true);
		
		session.saveOrUpdate(friend);
		tran.commit();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		Person friendPerson = (Person) session.get(Person.class, friendId);
		if(friendPerson == null) {
			friendPerson = new Person();
			friendPerson.setUser(friend);
		}
		friendPerson.setNameFormatted("A Lion");
		friendPerson.setAboutme("Sample Test 사자");
		friendPerson.setAge(18);
		
		session.saveOrUpdate(friendPerson);
		tran.commit();

	}
	
	@Test
	public void userPersonTest(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		
		Person person = user.getPerson();
		System.out.println(person.getUser().getPerson().getName());
		
		UserVisibility visible = user.getUserVisibility();
		System.out.println(visible.getName());
	}
	
	@Test
	public void makeFriend(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = (User) session.get(User.class, userId);
		User friend = (User) session.get(User.class, friendId);
		
		///user.addFriend(friend);
		user.addFriendsByMe(friend);
		friend.addFriendsByMe(user);
		
		session.saveOrUpdate(user);
		session.saveOrUpdate(friend);
		tran.commit();
		
		//
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = session.beginTransaction();
		
		user = (User) session.get(User.class, userId);
		//User friend = (User) session.get(User.class, friendId);
		//user = (User) session.get(User.class, friendId);
		Set<User> friends  = user.getFriendsByMe();
		//Set<User> friends  = user.getFriendsByOther();
		session.flush();
		System.out.println("Size of Friends=" + friends.size());
//		for(User u: friends)
//			System.out.println("Friend Name=" + u.getPerson().getName());
		
		//session.saveOrUpdate(user);
		tran.commit();
	}
	
	
//	@Test
//	public void addGadget(){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tran = session.beginTransaction();
//
//		User user = (User) session.get(User.class, userId);
//
//		// add first gadget
//		Gadget gadget = new Gadget();
//		gadget.setDeveloper(user);
//		gadget.setName("To do");
//		gadget.setRegisterDate(new Date());
//		gadget.setIconUrl("icon url sample");
//		gadget.setIntroduction("This is sample todo gadget");
//		gadget.setRegisterType("url");
//		gadget.setStatus("rg");
//		gadget.setSource("http://www.labpixies.com/campaigns/todo/todo.xml");
//		gadget.setRegisterDate(new Date());
//
//		Set<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
//		GadgetCategory category1 = (GadgetCategory) session.load(
//				GadgetCategory.class, "dating");
//		GadgetCategory category2 = (GadgetCategory) session.load(
//				GadgetCategory.class, "communication");
//		categorySet.add(category1);
//		categorySet.add(category2);
//
//		gadget.setCategories(categorySet);
//
//		session.saveOrUpdate(gadget);
//
//		// add second gadget
//		Gadget anotherGadget = new Gadget();
//		anotherGadget.setDeveloper(user);
//		anotherGadget.setName("Social Activities");
//		anotherGadget.setRegisterDate(new Date());
//		anotherGadget.setIconUrl("icon url sample");
//		anotherGadget.setIntroduction("This is another sample gadget");
//		anotherGadget.setRegisterType("url");
//		anotherGadget.setStatus("rg");
//		anotherGadget
//				.setSource("http://localhost:8080/gadgets/files/samplecontainer/examples/SocialActivitiesWorld.xml");
//		anotherGadget.setRegisterDate(new Date());
//
//		Set<GadgetCategory> categorySet2 = new HashSet<GadgetCategory>();
//		GadgetCategory category11 = (GadgetCategory) session.load(
//				GadgetCategory.class, "sports");
//		GadgetCategory category12 = (GadgetCategory) session.load(
//				GadgetCategory.class, "travel");
//		categorySet2.add(category11);
//		categorySet2.add(category12);
//
//		anotherGadget.setCategories(categorySet2);
//
//		session.saveOrUpdate(anotherGadget);
//		tran.commit();
//
//	}
	
	@Test
	public void deleteUsers(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		// add or create one user
		User user = (User) session.get(User.class, userId);
		//User friend = (User) session.get(User.class, friendId);
		
		session.delete(user);
		//session.delete(friend);
		
		tran.commit();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
