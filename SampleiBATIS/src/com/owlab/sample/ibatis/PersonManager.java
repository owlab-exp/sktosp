package com.owlab.sample.ibatis;

import java.util.Date;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.owlab.sample.ibatis.domain.Person;

/**
 * Very simple tutorial to test domain object & iBATIS
 * 
 * @author Ernest Lee
 *
 */
public class PersonManager {
	
	public static void main(String[] args) {
		
		PersonManager manager = new PersonManager();
		
		// create Person object to insert
		Person person = new Person();
		person.setId(1); // You may change this id if duplication occurs.
		person.setFirstName("Nomercy");
		person.setLastName("Cheny");
		person.setBirthDate(new Date());
		person.setHeightInMeters(170.5);
		person.setWeightInKilograms(700.5);
		
		manager.createPerson(person);
		
		// get Person by id
		Integer id = new Integer(1);
		
		Person anotherPerson = manager.getPerson(id);
		
		// System.out.println("anotherPerson's First Name: " + anotherPerson.getFirstName());
		
		// Update Person
		anotherPerson.setFirstName("Yasoos");
		anotherPerson.setWeightInKilograms(50.5);
		
		manager.updatePerson(anotherPerson);
		
		// Delete a Person
		
		manager.deletePerson(anotherPerson);
	}
	
	/**
	 * To create a person on database
	 * @param person
	 */
	public void createPerson(Person person) {
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
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
	public Person getPerson(Integer id) {
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
		Person person = null;
		try {
			person = (Person) sqlMap.queryForObject("getPerson", id);
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
	public int updatePerson(Person person) {
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
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
	public int deletePerson(Person person) {
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
		int r = -1;
		try {
			r = sqlMap.delete("deletePerson", person);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
