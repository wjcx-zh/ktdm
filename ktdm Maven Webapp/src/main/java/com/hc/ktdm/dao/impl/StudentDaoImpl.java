package com.hc.ktdm.dao.impl;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.StudentDao;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.model.Student;

public class StudentDaoImpl implements StudentDao{
	private SessionFactory sessionFactory;
	@Override
	public Student selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBySignUpInfo(String name, int snum, int cid) {
		String hql="from Course where cid=:c_id";
		Course course=(Course) sessionFactory.getCurrentSession().createQuery(hql).setParameter("c_id", cid).uniqueResult();
		
		for(Student s:course.getStudents()){
			if(s.getSname().equals(name)&&s.getSnum()==snum){
				return 1;
			}
		}
		return 2;
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
