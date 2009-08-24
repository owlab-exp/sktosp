/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 가젯 목록을 가져오기 위한 액션 클래스이다.
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ListGadgetsAction extends DeveloperBaseAction implements Pagenation{
	private static Logger logger = Logger.getLogger(ListGadgetsAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// GadgetDataList gadgetDataList;
	// Map<String, GadgetData> gadgetMap;
	private Map<String, Object> session;
	// Collection<GadgetData> gadgetList;
	// Set<Gadget> gadgets;
	/**
	 * 가젯 목록
	 */
	private List<Gadget> gadgetList;
	

	// properties for pagenation
	/**
	 * 한 페이지에 표시될 가젯 목록의 크기
	 */
	private int listSize = 8; // the size of gadget list
	/**
	 * 요쳥된 페이지
	 */
	private int requestedPage = 1;
	/**
	 * 전체 페이지 수
	 */
	private int maxPage = 1;
	
	/**
	 * 페이지 목록에 표시될 첫 페이지
	 */
	private int startPage = 1;
	/**
	 * 페이지 목록에 표시될 페이지의 총 수
	 */
	private int pageListSizeMax = 10;

	/**
	 * 페이지 목록
	 */
	private List<Integer> pageList = new ArrayList<Integer>();
	// end for pagenation
	/**
	 * 페지에 표시될 가젯의 목록을 만들기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			User user = (User) session.get(SKTOpenSocialSupportConstants.USER);

			String userId = user.getUserId();

			
			tx = hs.beginTransaction();

			logger.info("User ID=" + userId);
//			user = (User) hs.load(User.class, userId);

//			session.put(SKTOpenSocialSupportConstants.USER, user);
			
			Criteria crit = hs.createCriteria(Gadget.class);
			crit.add(Restrictions.eq("developer.id", userId));
			
			// to determine maximum possible pages
			int totalGadgetSize = crit.list().size();
			if(listSize > 0)
				maxPage = (int)Math.ceil((double)totalGadgetSize /listSize);
			

			// to determine the list of pages to be shown below the data table
			startPage = (requestedPage - (requestedPage%pageListSizeMax))+ 1; //1, 11, 21, ...
			for(int i = startPage, j = 1 ; j <= pageListSizeMax; i++, j++){
				if(i > maxPage)
					break;
				pageList.add(new Integer(i));
			}
			
			// make order before selection
			crit.addOrder(Order.desc("id"));
			
			// to determine result set
			if (requestedPage > 0){ 
				crit.setFirstResult((requestedPage - 1)*listSize);
			} else if (requestedPage <= 0){
				crit.setFirstResult(0);
				requestedPage = 1;
			} else if(requestedPage >= maxPage){
				crit.setFirstResult((maxPage -1)*listSize);
			}
			
			// fetch data
			crit.setMaxResults(listSize);
			gadgetList = (List<Gadget>)crit.list();
			
			
			for(Gadget gadget : gadgetList){
				//?? to fill data
				//gadget.getDeveloper().getPerson();
				gadget.getReviews().size();
				//logger.info(gadget.getFavoriteUsers());
			}

			logger.info("Number of gadgets of this page = " + gadgetList.size());

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;
		}

		
	}

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	

	/** 
	 * 요청된 페이지 번호를 가져온다.
	 * @see com.skt.opensocial.developer.Pagenation#getRequestedPage()
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/** 
	 * 요청된 페이지 번호를 셋팅한다
	 * @see com.skt.opensocial.developer.Pagenation#setRequestedPage(int)
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	

	/**
	 * 가젯 목록을 가져온다.
	 * @return 가젯 목록
	 */
	public List<Gadget> getGadgetList() {
		return gadgetList;
	}

	/**
	 * 가젯 목록을 셋팅한다
	 * @param gadgetList 가젯 목록
	 */
	public void setGadgetList(List<Gadget> gadgetList) {
		this.gadgetList = gadgetList;
	}

	/**
	 * 가젯 목록을 페이지로 표시하는 경우 전체 페이지 수를 가져온다
	 * @see com.skt.opensocial.developer.Pagenation#getMaxPage()
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * 가젯 목록의 전체 페이지를 셋팅한다
	 * @see com.skt.opensocial.developer.Pagenation#setMaxPage(int)
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * 페이지들을 가져온다. 예) 1,2,3,4,5,...
	 * @see com.skt.opensocial.developer.Pagenation#getPageList()
	 */
	public List<Integer> getPageList() {
		return pageList;
	}

	/**
	 * 페이지들을 셋팅한다. 예) 1,2,3,4,5, ...
	 * @see com.skt.opensocial.developer.Pagenation#setPageList(java.util.List)
	 */
	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

}
