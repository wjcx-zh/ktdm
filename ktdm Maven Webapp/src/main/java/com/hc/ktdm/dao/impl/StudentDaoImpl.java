package com.hc.ktdm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.StudentDao;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.model.Student;

public class StudentDaoImpl implements StudentDao{
	private SessionFactory sessionFactory;
	@Override
	public Student selectById(int id) {
		
		return sessionFactory.getCurrentSession().get(Student.class, id);
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
	public int insertStudent(Student student) {
		int ret=(Integer)sessionFactory.getCurrentSession().save(student);
		return ret!=0?1:0;
	}

	@Override
	public int deleteStudent(Student student) {
		sessionFactory.getCurrentSession().delete(student);
		return 1;
	}

	@Override
	public int updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return 1;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> selectAll() {
		String hql="from Student";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
