package com.skt.opensocial.persistence;

import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

public class DeleteGadget {
	
	@Test
	public void deleteGadgets(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Gadget gadget = (Gadget)session.get(Gadget.class, new Long(247));
		
		//GadgetPublish gp = (GadgetPublish)gadget.getGadgetPublish();
		Set<User> favoriteUsers = gadget.getFavoriteUsers();
		for(User u: favoriteUsers){
			u.removeFavoriteGadget(gadget);
			session.update(u);
		}
		
		session.delete(gadget);
		
		
		tran.commit();
		

	}

}
