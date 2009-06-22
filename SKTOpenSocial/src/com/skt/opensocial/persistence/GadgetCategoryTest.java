package com.skt.opensocial.persistence;

import org.hibernate.Session;




/**
 * Very simple tutorial to test domain object & iBATIS
 * 
 * @author Ernest Lee
 *
 */
public class GadgetCategoryTest {
	
	public static void main(String[] args) {
        Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
        hs.beginTransaction();
        
        //GadgetCategoryTest tester = new GadgetCategoryTest();
        
		hs.save(new GadgetCategory("communication","커뮤니케이션"));
		hs.save(new GadgetCategory("dating","데이트"));
		hs.save(new GadgetCategory("events","이벤트"));
		hs.save(new GadgetCategory("finance","경제"));
		hs.save(new GadgetCategory("food_and_drinks","음식"));
		hs.save(new GadgetCategory("games_and_fun","재미와 게임"));
		hs.save(new GadgetCategory("lifestyle","라이프 스타일"));
		hs.save(new GadgetCategory("movies_and_tv","영화와 TV"));
		hs.save(new GadgetCategory("music","음악"));
		hs.save(new GadgetCategory("news","뉴스"));
		hs.save(new GadgetCategory("politics","정치"));
		hs.save(new GadgetCategory("sports","스포츠"));
		hs.save(new GadgetCategory("tools","도구"));
		hs.save(new GadgetCategory("travel","여행"));
		hs.save(new GadgetCategory("video","비디오"));
        
		hs.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }
}