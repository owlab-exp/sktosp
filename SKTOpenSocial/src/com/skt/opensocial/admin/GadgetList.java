/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class GadgetList extends AdministratorBaseAction {
	private static Logger logger = Logger.getLogger(GadgetList.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Gadget> gadgets;
	
	int requestedPage = 1;
	
	public String execute(){
		//
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
		String userId = user.getUserId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		user = (User)hs.load(User.class, userId);
		
		
		session.put(SKTOpenSocialSupportConstants.USER, user);
		
		this.gadgets = user.getGadgets();
		logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
		
		hs.getTransaction().commit();

		return "SUCCESS";
	}

	
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	
	
}


/*
package com.skt.opensocial.admin;

import java.util.*;

public class GadgetList {
	
	private List<Gadget> gadgetlist;
	private String gadgetlistStr;
		
	public String execute() {
		List<Gadget> list	= new ArrayList<Gadget>();
		
		Gadget gadget	= new Gadget("가젯1", "이훈재");
		gadget.setCreatedDate("2009-06-03");
		gadget.setDesc("이훈재의 가젯입니다.");
		gadget.setNumRegUsers("10");
		gadget.setStatus("발행요청중");
		gadget.setNextstate("발행");
		list.add(gadget);

		gadget	= new Gadget("가젯2", "임성용");
		gadget.setCreatedDate("2009-05-01");
		gadget.setDesc("임성용의 가젯입니다.");
		gadget.setNumRegUsers("13");
		gadget.setStatus("활성");
		gadget.setNextstate("비활성");
		list.add(gadget);
		
		gadget	= new Gadget("가젯3", "오세준");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("오세준 가젯입니다.");
		gadget.setNumRegUsers("19");
		gadget.setStatus("비활성");
		gadget.setNextstate("활성");
		list.add(gadget);


		gadget	= new Gadget("가젯4", "김두리");
		gadget.setCreatedDate("2009-01-01");
		gadget.setDesc("김두리의 가젯입니다.");
		gadget.setNumRegUsers("29");
		gadget.setStatus("발행요청중");
		gadget.setNextstate("발행");
		list.add(gadget);

		setGadgetlist(list);
		setGadgetlistStr(list.toString());
				
		return "SUCCESS";
	}

	public List<Gadget> getGadgetlist() {
		return gadgetlist;
	}

	public void setGadgetlist(List<Gadget> gadgetlist) {
		this.gadgetlist = gadgetlist;
	}

	public String getGadgetlistStr() {
		return gadgetlistStr;
	}

	public void setGadgetlistStr(String gadgetlistStr) {
		this.gadgetlistStr = gadgetlistStr;
	}


	

}
*/