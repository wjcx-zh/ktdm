package com.hc.ktdm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.CourseDao;
import com.hc.ktdm.domain.DataSet;
import com.hc.ktdm.model.Course;

public class CourseDaoImpl implements CourseDao {
	private SessionFactory sessionFactory;
	@Override
	public Course findById(int id) {
		
		return sessionFactory.getCurrentSession().get(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		String hql="from Course";
		List<Course> courses=sessionFactory.getCurrentSession().createQuery(hql).list();
		return courses;
	}

	@Override
	public int addCourse(Course course) {
		
		return (Integer) sessionFactory.getCurrentSession().save(course);
	}

	@Override
	public int removeCourse(Course course) {
		Course cou=new Course();
		cou.setCid(course.getCid());
		cou.setCname(course.getCname());
		sessionFactory.getCurrentSession().evict(course);
		sessionFactory.getCurrentSession().delete(cou);
		return 1;
	}

	@Override
	public int modifyCourse(Course course) {
		sessionFactory.getCurrentSession().update(course);
		return 1;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
