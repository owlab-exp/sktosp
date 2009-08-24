package com.skt.opensocial.persistence;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class HibernateListener implements ServletContextListener {
	private Logger logger = Logger.getLogger(HibernateListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("Releasing resources");
		HibernateUtil.getSessionFactory().close();
		logger.info("Releasing completed");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
		logger.info("Initialization starting");
		HibernateUtil.getSessionFactory();
		logger.info("Initialization completed");

	}

}
