package com.skt.opensocial.persistence;

import org.hibernate.classic.Session;

import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.util.HibernateUtil;

public class GadgetCategoryInitialize {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(new GadgetCategory("communication","커뮤니케이션"));
		session.saveOrUpdate(new GadgetCategory("dating","데이트"));
		session.saveOrUpdate(new GadgetCategory("events","이벤트"));
		session.saveOrUpdate(new GadgetCategory("finance","경제"));
		session.saveOrUpdate(new GadgetCategory("food_and_drinks","음식"));
		session.saveOrUpdate(new GadgetCategory("games_and_fun","재미와 게임"));
		session.saveOrUpdate(new GadgetCategory("lifestyle","라이프 스타일"));
		session.saveOrUpdate(new GadgetCategory("movies_and_tv","영화와 TV"));
		session.saveOrUpdate(new GadgetCategory("music","음악"));
		session.saveOrUpdate(new GadgetCategory("news","뉴스"));
		session.saveOrUpdate(new GadgetCategory("politics","정치"));
		session.saveOrUpdate(new GadgetCategory("sports","스포츠"));
		session.saveOrUpdate(new GadgetCategory("tools","도구"));
		session.saveOrUpdate(new GadgetCategory("travel","여행"));
		session.saveOrUpdate(new GadgetCategory("video","비디오"));
		
		session.getTransaction().commit();
		
		
	}

}
