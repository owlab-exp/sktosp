package com.skt.opensocial.persistence;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonActivityTest {
	Logger logger = Logger.getLogger(PersonActivityTest.class);
	private static String userId = "usr1";
	//private static String friendId = "friend1";
	private static String actId_1 = "act1";
	private static String actId_2 = "act2";
	

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
		
		Person person = (Person) session.get(Person.class, userId);
		if(person == null) {
			person = new Person();
			//person.setId(userId);
			person.setUser(user);
		}
		person.setNameFormatted("My Name is This");
		person.setAboutme("HAHA MAN");
		
		session.saveOrUpdate(person);
		tran.commit();
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		User user = (User)session.load(User.class, userId);
		
		
		//session.delete(person); // No need. It will be deleted when user is deleted
		session.delete(user);
		
		tran.commit();
	}

	@Before
	public void setUp() throws Exception { 
		
	}
	
	@Test
	public void addActivity(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		
		//
		Activity act1 = new Activity();
		act1.setPerson(person);
		act1.setActivityId(actId_1);
		act1.setPostedTime(1234.123);
		act1.setUpdated(new Date());

		session.saveOrUpdate(act1);
		
		Activity act2 = new Activity();
		act2.setPerson(person);
		act2.setActivityId(actId_2);
		act2.setPostedTime(1234.123);
		act2.setUpdated(new Date());

		session.saveOrUpdate(act2);
		
		tran.commit();

	}
	
	@Test
	public void addActivityMediaItem(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		// Load an activity
		//Activity act1 = (Activity)session.load(Activity.class, actId_1);		
		
		//
		ActivityMediaItem ami1 = new ActivityMediaItem();
		ami1.setActivityId(actId_1); // required
		ami1.setUserId(userId); // required
		ami1.setMimeType("text/html");
		ami1.setType(ItemTypeEnum.audio);
		ami1.setThumbnailUrl("a thumb");
		
		session.saveOrUpdate(ami1);
		
		//
		ActivityMediaItem ami2= new ActivityMediaItem();
		ami2.setActivityId(actId_1); //required
		ami2.setUserId(userId); //required
		ami2.setMimeType("binary/jpeg");
		ami2.setType(ItemTypeEnum.image);
		ami2.setThumbnailUrl("second thumb");
		
		session.saveOrUpdate(ami2);
		tran.commit();

	}
	
	@Test
	public void listMediaItem(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Criteria crit = session.createCriteria(ActivityMediaItem.class);
		crit.setMaxResults(30);
		
		// all items
		List<ActivityMediaItem> items = (List<ActivityMediaItem>)crit.list();
		for(ActivityMediaItem item: items) {
			System.out.println("ACTIVITY_ID: "+item.getActivityId());
			System.out.println("USER_ID: "+item.getUserId());
		}
		
		// filer by an userId and an activityId
		crit = session.createCriteria(ActivityMediaItem.class);
		items = crit
		.add(Restrictions.eq("userId", userId))
		.add(Restrictions.eq("activityId", actId_1))
		.list();
		
		for(ActivityMediaItem item: items) {
			System.out.println("ACTIVITY_ID: "+item.getActivityId());
			System.out.println("USER_ID: "+item.getUserId());
		}
		
		tran.commit();

	}
	
	@Test
	public void deleteMediaItem(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Criteria crit = session.createCriteria(ActivityMediaItem.class);
		
		// filer by an userId and an activityId
		crit = session.createCriteria(ActivityMediaItem.class);
		List<ActivityMediaItem> items = crit
		.add(Restrictions.eq("userId", userId))
		.add(Restrictions.eq("activityId", actId_1))
		.list();
		
		for(ActivityMediaItem item: items) {
			session.delete(item);
		}
		
		tran.commit();

	}
	@Test
	public void addTemplateParam(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		// Load an activity
		//Activity act1 = (Activity)session.load(Activity.class, actId_1);		
		
		//
		ActivityTemplateParam atp1 = new ActivityTemplateParam();
		atp1.setActivityId(actId_1); // required
		atp1.setUserId(userId); // required
		atp1.setParamKey("text/html");
		atp1.setParamValue("a type");
		
		
		session.saveOrUpdate(atp1);
		
		//
		ActivityTemplateParam atp2 = new ActivityTemplateParam();
		atp2.setActivityId(actId_1); // required
		atp2.setUserId(userId); // required
		atp2.setParamKey("a key");
		atp2.setParamValue("a value");
		
		session.saveOrUpdate(atp2);
		tran.commit();

	}
	
	@Test
	public void listTempateParam(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Criteria crit = session.createCriteria(ActivityTemplateParam.class);
		//crit.setMaxResults(30);
		
		// all items
		List<ActivityTemplateParam> items = (List<ActivityTemplateParam>)crit.list();
		for(ActivityTemplateParam item: items) {
			System.out.println("ACTIVITY_ID: "+item.getActivityId());
			System.out.println("USER_ID: "+item.getUserId());
		}
		
		// filer by an userId and an activityId
		crit = session.createCriteria(ActivityTemplateParam.class);
		items = crit
		.add(Restrictions.eq("userId", userId))
		.add(Restrictions.eq("activityId", actId_1))
		.list();
		
		for(ActivityTemplateParam item: items) {
			System.out.println("ACTIVITY_ID: "+item.getActivityId());
			System.out.println("USER_ID: "+item.getUserId());
		}
		
		tran.commit();

	}
	
	@Test
	public void deleteTemplateParam(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Criteria crit = session.createCriteria(ActivityTemplateParam.class);
		
		// filer by an userId and an activityId
		crit = session.createCriteria(ActivityTemplateParam.class);
		List<ActivityTemplateParam> items = crit
		.add(Restrictions.eq("userId", userId))
		.add(Restrictions.eq("activityId", actId_1))
		.list();
		
		for(ActivityTemplateParam item: items) {
			session.delete(item);
		}
		
		tran.commit();

	}
	
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
