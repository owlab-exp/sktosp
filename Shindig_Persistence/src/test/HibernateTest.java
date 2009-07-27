package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> idSet = new HashSet<String>();
		// List<String> allUserIds = null;
		// try {
		// // List<String> allUserIds = sqlMap.queryForList(
		// // "getAllUserIds" );
		// Session hs = HibernateUtil.getSessionFactory()
		// .getCurrentSession();
		// Transaction tran = hs.beginTransaction();
		//
		// // Criteria crit = hs.createCriteria(User.class);
		// allUserIds = (List<String>) hs
		// .createQuery("select id from User").list();
		//
		// tran.commit();
		//
		// } catch (Exception e) {
		// HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }
		// for (String id : allUserIds ) {
		// idSet.add( id );
		// }

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();

		// List<String> friendsIds = sqlMap.queryForList("getFriendsIds",user);

		List<String> friendsIds = new ArrayList<String>();

		User userObject = (User) hs.get(User.class, "john.doe");
		Set<User> friends = userObject.getFriendsByMe();
		Set<User> friendsByOthers = userObject.getFriendsByOther();

		friends.addAll(friendsByOthers);

		Set<User> tempFriends = new HashSet<User>();
		tempFriends.addAll(friends);
		
		for (User friend : tempFriends) {
			if (!friend.getPerson().getHasapp())
				friends.remove(friend);
		}

		for (User friend : friends) {
			friendsIds.add(friend.getId());
		}
		idSet.addAll(friendsIds);
		
		// for (String id : friendsIds) {
		// idSet.add(id);
		// }
		tran.commit();
	}

}
