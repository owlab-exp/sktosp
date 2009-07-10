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

public class FavoriteGadgetTest {
	Logger logger = Logger.getLogger(FavoriteGadgetTest.class);
	private static String developerId = "nash";
	private static String userId = "friend2";
	private static Long gadgetId = 230L;

	

	
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
		
		logger.info("Number of gadgets=" + gadgets.size());
		for(Gadget g: gadgets) {
			logger.info("Developer=" + g.getDeveloper().getPerson().getNameFormatted());
		}
		
		
		Gadget gadget = (Gadget) session.get(Gadget.class, gadgetId);
		Collection<User> users = gadget.getFavoriteUsers();
		
		//assertEquals("Number of gadgets", 1, gadgets.size());
		
		logger.info("Number of users=" + users.size());
//		User reviewer = (User)session.load(User.class, userId);
//		Collection<Gadget> reviewsFromReviewer = gadget.getReviews();
//		
//		assertEquals("Number of reviews", 1, reviewsFromReviewer.size());
		

		tran.commit();
		
		for(Gadget g: gadgets) {
			logger.info("Developer=" + g.getDeveloper().getPerson().getNameFormatted());
		}

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
	
}
