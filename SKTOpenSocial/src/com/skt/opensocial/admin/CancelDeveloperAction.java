/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.HashSet;
import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Sejoon Oh
 *
 */
public class CancelDeveloperAction extends DeveloperBaseAction {
	
	private String developerId;
	private User developer;

	public String execute(){
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		developer = (User)hs.load(User.class, developerId);

	    System.out.println("developerId--->" + developerId);

	    developer.setIsDeveloper(false);

		hs.saveOrUpdate(developer);
		hs.getTransaction().commit();

		System.out.println("Update successfully!");

		return "SUCCESS";
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

}
