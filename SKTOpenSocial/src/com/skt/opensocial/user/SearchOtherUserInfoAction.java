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
 * 특정 사용자의 상세정보를 보기 위한 액션 클래스
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
	
	/**
	 * 조회하고자 하는 사용자 ID
	 */
	String userId;
	/**
	 * 조회되는 사용자 ID
	 */
	String otherUserId;
	/**
	 * 조회되는 사용자의 선호가젯 목록
	 */
	Set<Gadget> otherUserGadgets;
	
	/**
	 * 사용자 이름
	 */
	String name;
	/**
	 * 사용자 등록일
	 */
	Date registeredDate;
	/**
	 * 나이
	 */
	int age;
	
	/**
	 * 조회되는 사용자 오브젝트
	 */
	User otherUser;
	
	/**
	 * 전화번호
	 */
	String phoneNumber;
	
	String personalInfoOpen;
	String favoriteGadgetListOpen;
	/**
	 * 친구 여부
	 */
	String flagFriend = "false";
	String flagOtherFriend = "false";
	/**
	 * 조회되는 사용자가 조회하는 사용자인지 여부
	 */
	String flagMyself = "false";

	
	public String getFlagOtherFriend() {
		return flagOtherFriend;
	}

	public void setFlagOtherFriend(String flagOtherFriend) {
		this.flagOtherFriend = flagOtherFriend;
	}

	/**
	 * 전화번호를 가져온다
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 전화번호를 셋팅한다
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 조회하는 사용자가 조회되는 사용자와 일치하는지를 알아본다
	 * @return
	 */
	public String getFlagMyself() {
		return flagMyself;
	}

	/**
	 * 조회하는 사용자가 조회되는 사용자인지를 셋팅한다
	 * @param flagMyself
	 */
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

	/**
	 * 친구인지를 알아본다
	 * @return
	 */
	public String getFlagFriend() {
		return flagFriend;
	}

	/**
	 * 친구인지를 셋팅한다
	 * @param flagFriend
	 */
	public void setFlagFriend(String flagFriend) {
		this.flagFriend = flagFriend;
	}

	/**
	 * 조회되는 사용자의 선호 가젯 목록을 가져온다
	 * @return
	 */
	public Set<Gadget> getOtherUserGadgets() {
		return otherUserGadgets;
	}

	/**
	 * 조회되는 사용자의 선호 가젯 목록을 셋팅한다
	 * @param otherUserGadgets
	 */
	public void setOtherUserGadgets(Set<Gadget> otherUserGadgets) {
		this.otherUserGadgets = otherUserGadgets;
	}

	/**
	 * 조회되는 사용자 오브젝트를 가져온다
	 * @return
	 */
	public User getOtherUser() {
		return otherUser;
	}

	/**
	 * 조회되는 사용자 오브젝트를 셋팅한다
	 * @param otherUser
	 */
	public void setOtherUser(User otherUser) {
		this.otherUser = otherUser;
	}

	/**
	 * 조회되는 사용자 ID를 가져온다
	 * @return
	 */
	public String getOtherUserId() {
		return otherUserId;
	}

	/**
	 * 조회되는 사용자 ID를 셋팅한다
	 * @param otherUserId
	 */
	public void setOtherUserId(String otherUserId) {
		this.otherUserId = otherUserId;
	}

	/**
	 * 사용자 이름을 가져온다
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 사용자 이름을 셋팅한다
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#getUserId()
	 */
	public String getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#setUserId(java.lang.String)
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 사용자 등록일을 가져온다
	 * @return
	 */
	public Date getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * 사용자 등록일을 셋팅한다
	 * @param registeredDate
	 */
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	/**
	 * 나이를 가져온다
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 나이를 셋팅한다
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see com.skt.opensocial.user.ActivityBaseManager#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	
	/**
	 * 사용자의 상세정보를 조회하기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
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
