package com.skt.opensocial.wrapper.persistence.spi;

import java.util.Date;

import com.skt.opensocial.wrapper.persistence.shindigmodelsample.PersonImpl;
import com.skt.opensocial.wrapper.persistence.utils.IBATISSqlMapper;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Very simple tutorial to test domain object & iBATIS
 * 
 * @author Duri Kim
 *
 */
public class PersonDBService {
	
	public static void main(String[] args) {
		
		PersonDBService manager = new PersonDBService();
		
		// create Person object to insert
		PersonImpl person = new PersonImpl();
		person.setId("comisme"); // You may change this id if duplication occurs.
		person.setBirthday(new Date());
		person.setAboutMe("MSIT-SE student");
		
		manager.createPerson(person);
		
		// get Person by id
		String id = new String("comisme");
		
		PersonImpl anotherPerson = manager.getPerson(id);
		
		// System.out.println("anotherPerson's First Name: " + anotherPerson.getFirstName());
		
		// Update Person
		anotherPerson.setFashion("Casual");
		
		manager.updatePerson(anotherPerson);
		
		// Delete a Person
		
		//manager.deletePerson(anotherPerson);
	}
	
	/**
	 * To create a person on database
	 * @param person
	 */
	public void createPerson(PersonImpl person) {
		SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
		try {
			sqlMap.insert("insertPerson", person);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To get person data by id from database
	 * @param id
	 * @return
	 */
	public PersonImpl getPerson(String id) {
		SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
		PersonImpl person = null;
		try {
			person = (PersonImpl) sqlMap.queryForObject("getPerson", id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public int updatePerson(PersonImpl person) {
		SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
		int r = -1;
		try {
			r = sqlMap.update("updatePerson", person);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * To delete a row in PERSON table
	 * @param person
	 * @return
	 */
	public int deletePerson(PersonImpl person) {
		SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
		int r = -1;
		try {
			r = sqlMap.delete("deletePerson", person);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
