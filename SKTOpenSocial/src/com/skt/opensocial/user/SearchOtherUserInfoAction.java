/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Date;


import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.Info2AttributeEnum;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;


import com.skt.opensocial.persistence.HibernateUtil;

import com.skt.opensocial.persistence.User;

/**
 * @author Seong yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SearchOtherUserInfoAction extends ActivityBaseManager{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session;
	
	String userId;
	String otherUserId;
	Set<Gadget> otherUserGadgets;
	
	String name;
	Date registeredDate;
	int age;
	
	User otherUser;
	
	String phoneNumber;
	
	String personalInfoOpen;
	String favoriteGadgetListOpen;
	String flagFriend = "false";
	String flagOtherFriend = "false";
	String flagMyself = "false";

	
	public String getFlagOtherFriend() {
		return flagOtherFriend;
	}

	public void setFlagOtherFriend(String flagOtherFriend) {
		this.flagOtherFriend = flagOtherFriend;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFlagMyself() {
		return flagMyself;
	}

	public void setFlagMyself(String flagMyself) {
		this.flagMyself = flagMyself;
	}

	public String getPersonalInfoOpen() {
		return personalInfoOpen;
	}

	public void setPersonalInfoOpen(String personalInfoOpen) {
		this.personalInfoOpen = personalInfoOpen;
	}

	public String getFavoriteGadgetListOpen() {
		return favoriteGadgetListOpen;
	}

	public void setFavoriteGadgetListOpen(String favoriteGadgetListOpen) {
		this.favoriteGadgetListOpen = favoriteGadgetListOpen;
	}

	public String getFlagFriend() {
		return flagFriend;
	}

	public void setFlagFriend(String flagFriend) {
		this.flagFriend = flagFriend;
	}

	public Set<Gadget> getOtherUserGadgets() {
		return otherUserGadgets;
	}

	public void setOtherUserGadgets(Set<Gadget> otherUserGadgets) {
		this.otherUserGadgets = otherUserGadgets;
	}

	public User getOtherUser() {
		return otherUser;
	}

	public void setOtherUser(User otherUser) {
		this.otherUser = otherUser;
	}

	public String getOtherUserId() {
		return otherUserId;
	}

	public void setOtherUserId(String otherUserId) {
		this.otherUserId = otherUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	
	public String execute() throws Exception {
	
		//
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getUserId();
					
			user = (User)hs.load(User.class, userId);
						
			otherUser = (User)hs.load(User.class, otherUserId);
			Person person = otherUser.getPerson();
			
			personalInfoOpen = person.getProfileurl();
			favoriteGadgetListOpen = person.getThumbnailurl();
			if (personalInfoOpen == null)
				personalInfoOpen = InfoOpenEnum.ALL;
			if (favoriteGadgetListOpen == null)
				favoriteGadgetListOpen = InfoOpenEnum.ALL;
			
			if (otherUser.getFriendsByMe().contains(user))
				flagOtherFriend = "true";
			
			if (user.getFriendsByMe().contains(otherUser))
				flagFriend = "true";
			
			if (otherUserId.equals(userId))
				flagMyself = "true";
			
			if (personalInfoOpen.equals(InfoOpenEnum.ONLYF) && flagOtherFriend.equals("false"))
				personalInfoOpen = InfoOpenEnum.onlyf;
			
			if (favoriteGadgetListOpen.equals(InfoOpenEnum.ONLYF) && flagOtherFriend.equals("false"))
				favoriteGadgetListOpen = InfoOpenEnum.onlyf;
			
			System.out.println("--------A " 
					+ personalInfoOpen + " : " 
					+ favoriteGadgetListOpen + " : "
					+ flagFriend + " : "
					+ flagMyself);
			
			name = person.getName();
			registeredDate = otherUser.getRegisteredDate();
			//System.out.println("--------------------------------------B " + registeredDate);
			age = person.getAge();
			
			phoneNumber ="";
			Set<PersonAdditionalInfo2> set = person.getAdditionalInfo2s();
			for (PersonAdditionalInfo2 p: set)
			{
				if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers) && p.getPrimary())
				{
					phoneNumber = p.getValue();
					break;
				}
			}
			otherUserGadgets = otherUser.getFavoriteGadgets();
			
			for (Gadget g: otherUserGadgets)
			{
				g.getId();
				g.getName();
				g.getDeveloper().getPerson().getName();
				g.getPublishDate();
				g.getFavoriteUsers().size();
				g.getIntroduction();
				
			}
			//System.out.println("--------------------------------------C");

			tx.commit();
			//System.out.println("--------------------------------------D");
			
			
			
			//System.out.println("--------------------------------------E : " + ActivityTypeEnum.otherUserInfo + userId + otherUserId);
			
			super.addActivity(ActivityTypeEnum.otherUserInfo, userId, otherUserId, null);
			
			//System.out.println("--------------------------------------F");
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

}
