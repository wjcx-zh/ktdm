package com.hc.ktdm.dao.impl;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.NameTableDao;
import com.hc.ktdm.model.NameTable;

public class NameTableDaoImpl implements NameTableDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insertIntoSignupTable(NameTable nameTable) {
		sessionFactory.getCurrentSession().save(nameTable);
	}

}
