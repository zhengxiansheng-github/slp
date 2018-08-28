package com.slp.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class Tool extends HibernateDaoSupport{
	
	@Resource(name="sessionFactory")
	public void setHibernateDaoSupport(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
}
