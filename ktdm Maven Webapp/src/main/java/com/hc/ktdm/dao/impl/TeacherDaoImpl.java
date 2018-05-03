package com.hc.ktdm.dao.impl;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.TeacherDao;
import com.hc.ktdm.model.Teacher;

public class TeacherDaoImpl implements TeacherDao{
	private SessionFactory sessionFactory;
	@Override
	public Teacher selectById(int id) {
		
		return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class, id);
	}


	@Override
	public Teacher selectByLoginInfo(String name, String password) {
		String hql="from Teacher where tname= :name and password= :pass";
		Teacher t=(Teacher) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("pass", password).uniqueResult();
		System.out.println(t);
		return t;
	}
	@Override
	public void insertTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().save(teacher);
		
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().delete(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().update(teacher);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
