package com.skt.opensocial.persistence;


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

import com.skt.opensocial.persistence.Address;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAccount;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.PersonAppData;
import com.skt.opensocial.persistence.PersonOrganization;
import com.skt.opensocial.persistence.PersonUrl;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.util.HibernateUtil;

public class PersonTest {
	Logger logger = Logger.getLogger(PersonTest.class);
	private static String userId = "usr1";
	//private static String friendId = "friend1";
	

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
	public void setUp() throws Exception { // Create a User for Test
		
	}
	
	@Test
	public void addVariousData(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		
		//Additional Info 1s
		PersonAdditionalInfo1 info11 = new PersonAdditionalInfo1();
		info11.setPerson(person); // required
		info11.setAttribute(Info1AttributeEnum.activities);
		info11.setValue("val1");
		
		session.saveOrUpdate(info11);
		
		PersonAdditionalInfo1 info12 = new PersonAdditionalInfo1();
		info12.setPerson(person); // required
		info12.setAttribute(Info1AttributeEnum.books);
		info12.setValue("val2");
		
		session.saveOrUpdate(info12);
		
		//Additional Info 2s
		PersonAdditionalInfo2 info21 = new PersonAdditionalInfo2();
		info21.setPerson(person);
		info21.setAttribute(Info2AttributeEnum.emails);
		info21.setPrimary(false);
		info21.setType("hi");
		info21.setValue("val1");
		
		session.saveOrUpdate(info21);
		
		PersonAdditionalInfo2 info22 = new PersonAdditionalInfo2();
		info22.setPerson(person);
		info22.setAttribute(Info2AttributeEnum.photos);
		info22.setPrimary(true);
		info22.setType("hi-a");
		info22.setValue("val1-a");
		
		session.saveOrUpdate(info22);
		
		//Accounts
		PersonAccount acct1 = new PersonAccount();
		acct1.setPerson(person);
		acct1.setDomain("dom1");
		acct1.setUserName("what name 1");
		
		session.saveOrUpdate(acct1);
		
		PersonAccount acct2 = new PersonAccount();
		acct2.setPerson(person);
		acct2.setDomain("dom2");
		acct2.setUserName("what name 2");
		
		session.saveOrUpdate(acct2);
		
		//Addresses
		Address add1 = new Address();
		add1.setPerson(person);
		add1.setCountry("S. Korea");
		add1.setFormatted("an address");
		add1.setPrimary(false);
		
		session.saveOrUpdate(add1);
		
		Address add2 = new Address();
		add2.setPerson(person);
		add2.setCountry("N. Korea");
		add2.setFormatted("another address");
		add2.setPrimary(true);
		
		session.saveOrUpdate(add2);
		
		//Organizations
		PersonOrganization po1 = new PersonOrganization();
		po1.setPerson(person);
		po1.setName("org1");
		po1.setAddressType("none");
		po1.setTitle("ceo");
		
		session.saveOrUpdate(po1);
		
		PersonOrganization po2 = new PersonOrganization();
		po2.setPerson(person);
		po2.setName("org2");
		po2.setAddressType("none1");
		po2.setTitle("cio");
		
		session.saveOrUpdate(po2);
		
		//AppData
		PersonAppData ad1 = new PersonAppData();
		ad1.setPerson(person);
		ad1.setData("data1");
		ad1.setAppId("app1");
		ad1.setField("field1");
		
		session.saveOrUpdate(ad1);
		
		PersonAppData ad2 = new PersonAppData();
		ad2.setPerson(person);
		ad2.setData("data2");
		ad2.setAppId("app2");
		ad2.setField("field2");
		
		session.saveOrUpdate(ad2);
		
		//Urls
		PersonUrl url1 = new PersonUrl();
		url1.setPerson(person);
		url1.setLinkText("link1");
		url1.setType("src");
		url1.setValue("none");
		url1.setPrimary(false);
		
		session.saveOrUpdate(url1);
		
		PersonUrl url2 = new PersonUrl();
		url2.setPerson(person);
		url2.setLinkText("link2");
		url2.setType("img");
		url2.setValue("none");
		url2.setPrimary(true);
		
		session.saveOrUpdate(url2);

		tran.commit();

	}
	
	@Test
	public void deleteInfo1(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonAdditionalInfo1> info1s = person.getAdditionalInfo1s();
		
		for(PersonAdditionalInfo1 info1: info1s)
			session.delete(info1);
		
		tran.commit();
	}
	
	@Test
	public void deleteInfo2(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonAdditionalInfo2> info2s = person.getAdditionalInfo2s();
		
		for(PersonAdditionalInfo2 info2: info2s)
			session.delete(info2);
		
		tran.commit();
	}
	
	@Test
	public void deleteAccounts(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonAccount> coll = person.getAccounts();
		
		for(PersonAccount element: coll)
			session.delete(element);
		
		tran.commit();
	}
	
	@Test
	public void deleteAddresses(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<Address> coll = person.getAddresses();
		
		for(Address element: coll)
			session.delete(element);
		
		tran.commit();
	}
	
	@Test
	public void deleteOrganizations(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonOrganization> coll = person.getOrganizations();
		
		for(PersonOrganization element: coll)
			session.delete(element);
		
		tran.commit();
	}
	
	@Test
	public void deleteAppData(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonAppData> coll = person.getAppData();
		
		for(PersonAppData element: coll)
			session.delete(element);
		
		tran.commit();
	}
	
	@Test
	public void deleteUrls(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = (Person) session.load(Person.class, userId);
		Collection<PersonUrl> coll = person.getUrls();
		
		for(PersonUrl element: coll)
			session.delete(element);
		
		tran.commit();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
}
