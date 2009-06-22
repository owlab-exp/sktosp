package com.skt.opensocial.persistence;

import java.util.Date;

import org.hibernate.Session;

import com.skt.opensocial.security.PasswordEncryptor;


/**
 * Very simple tutorial to test domain object & iBATIS
 * 
 * @author Ernest Lee
 *
 */
public class UserTest {
	
	public static void main(String[] args) {
        Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
        hs.beginTransaction();
        
        PasswordEncryptor pe = PasswordEncryptor.getInstance();
        
        User aUser = new User();
        aUser.setUserId("nash");
        aUser.setPassword(pe.encrypt("nash"));
        aUser.setIsAdministrator(true);
        aUser.setIsDeveloper(true);
        
        Person aPerson = new Person();
        aPerson.setPersonId(aUser.getUserId());
        aPerson.setName("팀 NASH");
        aUser.setPerson(aPerson);
        aUser.setRegisteredDate(new Date());
        
        
        // create and store
        //tester.deleteUser(aUser);
        hs.saveOrUpdate(aUser);
       
        hs.getTransaction().commit();
        
        HibernateUtil.getSessionFactory().close();
    }




}
