package com.hc.ktdm.dao;

import com.hc.ktdm.model.Course;

public interface CourseDao {
	public Course findById(int id);
	//public Course findByFK_t(int tid);
	public void addTeacher(Course course);
	public void removeTeacher(Course course);
	public void modifyTeacher(Course course);
}
