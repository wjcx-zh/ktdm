package com.hc.ktdm.dao.impl;

import java.util.List;

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
	public List<Manager> selectAll() {
		String hql="from Manager";
		
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@Override
	public Manager selectByLoginInfo(String name, String password) {
		String hql="from Manager where mname= :name and password= :pass";
		Manager m=(Manager) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("pass", password).uniqueResult();
		return m;
	}

	@Override
	public int insertManager(Manager manager) {
		Integer result=(Integer) sessionFactory.getCurrentSession().save(manager);
		return result>0?1:0;
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
