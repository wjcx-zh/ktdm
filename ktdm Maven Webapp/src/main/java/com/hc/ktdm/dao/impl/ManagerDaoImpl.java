package com.hc.ktdm.dao.impl;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.model.Manager;


public class ManagerDaoImpl implements ManagerDao{
	private SessionFactory sessionFactory;
	@Override
	public Manager selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager selectByLoginInfo(String name, String password) {
		String hql="from Manager where mname= :name and password= :pass";
		Manager m=(Manager) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("pass", password).uniqueResult();
		return m;
	}

	@Override
	public void insertManager(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
