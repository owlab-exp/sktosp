package com.skt.opensocial.persistence;

import java.util.Date;

import org.hibernate.Session;

import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.common.GadgetStatusConstants;




/**
 * Very simple tutorial to test domain object & iBATIS
 * 
 * @author Ernest Lee
 *
 */
public class GadgetTest {
	
	public static void main(String[] args) {
        Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
        hs.beginTransaction();
        
        //GadgetCategoryTest tester = new GadgetCategoryTest();
        Gadget gadget = new Gadget();
        gadget.setDeveloperId("nash");
        gadget.setIntroduction("발행 거절된 가젯");
        gadget.setName("나쁜 가젯");
        gadget.setRegisterDate(new Date());
        //gadget.setPublishDate(new Date());
        gadget.setRegisterType(GadgetRegisterTypeConstants.URL);
        gadget.setSource("샘플 URL");
        gadget.setStatus(GadgetStatusConstants.PUBLISH_DENIED);
        
        hs.saveOrUpdate(gadget);
        
		hs.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }
}