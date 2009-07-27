package com.skt.opensocial.wrapper.persistence.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.Enum;
import org.apache.shindig.protocol.model.EnumImpl;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.core.model.AccountImpl;
import org.apache.shindig.social.core.model.AddressImpl;
import org.apache.shindig.social.core.model.BodyTypeImpl;
import org.apache.shindig.social.core.model.ListFieldImpl;
import org.apache.shindig.social.core.model.NameImpl;
import org.apache.shindig.social.core.model.OrganizationImpl;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.core.model.UrlImpl;
import org.apache.shindig.social.opensocial.model.Account;
import org.apache.shindig.social.opensocial.model.Address;
import org.apache.shindig.social.opensocial.model.BodyType;
import org.apache.shindig.social.opensocial.model.Drinker;
import org.apache.shindig.social.opensocial.model.ListField;
import org.apache.shindig.social.opensocial.model.LookingFor;
import org.apache.shindig.social.opensocial.model.NetworkPresence;
import org.apache.shindig.social.opensocial.model.Organization;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.model.Smoker;
import org.apache.shindig.social.opensocial.model.Url;
import org.apache.shindig.social.opensocial.model.Person.Gender;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.PersonService;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.skt.opensocial.persistence.DrinkerEnum;
import com.skt.opensocial.persistence.GenderEnum;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Info1AttributeEnum;
import com.skt.opensocial.persistence.Info2AttributeEnum;
import com.skt.opensocial.persistence.NetworkpresenceEnum;
import com.skt.opensocial.persistence.PersonAccount;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.SmokerEnum;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.wrapper.persistence.domain.OrganizationDB;
import com.skt.opensocial.wrapper.persistence.domain.PersonAddInfoQueryParam;
import com.skt.opensocial.wrapper.persistence.domain.PersonDB;
import com.skt.opensocial.wrapper.persistence.util.HDBTableMapper;

/**
 * Implementation of supported services backed by a JSON DB.
 */
@Singleton
public class HPersonDBService implements PersonService {

	// private SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();

	private static final Comparator<Person> NAME_COMPARATOR = new Comparator<Person>() {
		public int compare(Person person, Person person1) {
			String name = person.getName().getFormatted();
			String name1 = person1.getName().getFormatted();
			return name.compareTo(name1);
		}
	};

	@Inject
	public HPersonDBService() {

	}

	public Future<RestfulCollection<Person>> getPeople(Set<UserId> userIds,
			GroupId groupId, CollectionOptions options, Set<String> fields,
			SecurityToken token) throws ProtocolException {

		List<Person> result = Lists.newArrayList();

		try {
			Set<String> idSet = getIdSet(userIds, groupId, options, token);

			for (String id : idSet) {
				Person person = this.getPersonFromDB(id, fields, token);

				if (person != null)
					result.add(person);
			}

			if (GroupId.Type.self == groupId.getType() && result.isEmpty()) {
				throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST,
						"Person not found");
			}

			// We can pretend that by default the people are in top friends
			// order
			if (options.getSortBy().equals(Person.Field.NAME.toString())) {
				Collections.sort(result, NAME_COMPARATOR);
			}

			if (options.getSortOrder() == SortOrder.descending) {
				Collections.reverse(result);
			}

			

			int totalSize = result.size();
			
			int max = options.getMax();
			if (options.getMax() < 0)
				max = 20;
			
			int last = options.getFirst() + max;
			
			if (options.getFirst() <= totalSize) {
				result = result.subList(options.getFirst(), Math.min(last,
						totalSize));
			}

			return ImmediateFuture.newInstance(new RestfulCollection<Person>(
					result, options.getFirst(), totalSize));

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProtocolException(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e
							.getMessage(), e);
		}
	}

	public Future<Person> getPerson(UserId id, Set<String> fields,
			SecurityToken token) throws ProtocolException {

		try {
			String userId = id.getUserId(token);

			Person person = this.getPersonFromDB(userId, fields, token);

			if (id != null && person != null) {
				return ImmediateFuture.newInstance(person);
			} 
			
			throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST,
			"Person not found");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProtocolException(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e
							.getMessage(), e);
		}
	}

	private Person getPersonFromDB(String userId, Set<String> fields,
			SecurityToken token) {
		Person person = new PersonImpl();
//		PersonDB personDB = new PersonDB();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = null;
		
		try {
			
			tran = hs.beginTransaction();
			
			com.skt.opensocial.persistence.Person personDB = (com.skt.opensocial.persistence.Person) hs.get(com.skt.opensocial.persistence.Person.class, userId);
			
			if( personDB != null ) {
				person = (PersonImpl) HDBTableMapper
				.getPersonFromPersonDB(personDB);
				
				tran.commit();
				return person;
			}
			
			tran.commit();
			return null;			
			
			
		} catch (Exception e) {
			if ( tran != null )
				tran.rollback();
			
			e.printStackTrace();
			throw new ProtocolException(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e
							.getMessage(), e);
		}

	}


	/**
	 * Get the set of user id's for a set of users and a group
	 */
	private Set<String> getIdSet(Set<UserId> users, GroupId group,
			CollectionOptions options, SecurityToken token)
			throws JSONException {
		Set<String> ids = new HashSet<String>();
		for (UserId user : users) {
			ids.addAll(getIdSet(user, group, options, token));

		}
		return ids;
	}

	/**
	 * Get the set of user id's from a user and group
	 */
	@SuppressWarnings("unchecked")
	private Set<String> getIdSet(UserId userId, GroupId groupId,
			CollectionOptions options, SecurityToken token)
			throws JSONException {

		String user = userId.getUserId(token);

		if (groupId == null) {
			return ImmutableSortedSet.of(user);
		}

		Set<String> idSet = new HashSet<String>();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = null;

		switch (groupId.getType()) {
		case all:
			// idSet.add(user);
			List<String> allUserIds = null;
			try {
				// List<String> allUserIds = sqlMap.queryForList(
				// "getAllUserIds" );
				tran = hs.beginTransaction();

				// Criteria crit = hs.createCriteria(User.class);
				Query q = hs.createQuery("select id from User");
				allUserIds = (List<String>) q.list();

				tran.commit();

			} catch (Exception e) {
				if (tran != null)
					tran.rollback();
				HibernateUtil.getSessionFactory().getCurrentSession()
						.getTransaction().rollback();
				e.printStackTrace();
			}

			for (String id : allUserIds) {
				idSet.add(id);
			}
			break;
		case groupId:
			
		case friends:
			try {
				/**
				 * <p>
				 * This filter can be any field of the object being filtered or
				 * the special js filters, hasApp or topFriends. Other special
				 * Filters defined in the OpenSocial v.9 specification are
				 * </p>
				 * <dl>
				 * <dt>all</dt>
				 * <dd>Retrieves all friends</dd>
				 * <dt>hasApp</dt>
				 * <dd>Retrieves all friends with any data for this application.
				 * </dd>
				 * <dt>'topFriends</dt>
				 * <dd>Retrieves only the user's top friends.</dd>
				 * <dt>isFriendsWith</dt>
				 * <dd>Only "hasApp filter" is implemented here</dd>
				 * </dl>
				 */

				tran = hs.beginTransaction();
				
				//List<String> friendsIds = sqlMap.queryForList("getFriendsIds",user);

				List<String> friendsIds = new ArrayList<String>();
				
				User userObject = (User)hs.get(User.class, user);
				
				Set<User> friends = userObject.getFriendsByMe();
				Set<User> friendsByOthers = userObject.getFriendsByOther();
				
				friends.addAll(friendsByOthers);
				
				if (options.getFilter() != null
						&& options.getFilter().equals("hasApp")) {

					Set<User> tempFriends = new HashSet<User>();
					tempFriends.addAll(friends);
					
					for (User friend : tempFriends) {
						if (!friend.getPerson().getHasapp())
							friends.remove(friend);
					}
				}

				for(User friend: friends) {
					friendsIds.add(friend.getId());
				}
				idSet.addAll(friendsIds);


				tran.commit();
			} catch (Exception e) {
				if (tran != null)
					tran.rollback();
				
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				e.printStackTrace();
			}

			break;
		case self:
			idSet.add(user);
			break;
		}
		return idSet;
	}
	
	
	
}





