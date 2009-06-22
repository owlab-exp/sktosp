package com.skt.opensocial.persistence;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

public class HibernateFilter implements Filter {
	Logger logger = Logger.getLogger(HibernateFilter.class);
	
	private SessionFactory sf = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		sf.getCurrentSession().beginTransaction();
		chain.doFilter(request, response);
		sf.getCurrentSession().getTransaction().commit();

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		sf = HibernateUtil.getSessionFactory();
		logger.log(Level.INFO, "Hibernate initialized successfully");
	}

}
