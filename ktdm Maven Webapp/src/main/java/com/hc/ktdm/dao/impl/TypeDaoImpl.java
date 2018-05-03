package com.hc.ktdm.dao.impl;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.TypeDao;
import com.hc.ktdm.model.Type;

public class TypeDaoImpl implements TypeDao {
	private SessionFactory sessionFactory;
	@Override
	public Type selectById(Integer id) {
		
		return sessionFactory.getCurrentSession().get(Type.class, id);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
