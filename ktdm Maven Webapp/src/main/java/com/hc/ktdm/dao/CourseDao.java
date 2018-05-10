package com.hc.ktdm.dao;

import java.util.List;


import com.hc.ktdm.model.Course;

public interface CourseDao {
	public Course findById(int id);
	public List<Course> findAll();
	//public Course findByFK_t(int tid);
	public int addCourse(Course course);
	public int removeCourse(Course course);
	public int modifyCourse(Course course);
}
