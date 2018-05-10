package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.model.Course;

public interface CourseService {
	public Course findById(int id);
	public List<Course> findAll();
	//public Course findByLoginInfo(String name,String password);
	public int addCourse(Course course);
	public int removeCourse(Course course);
	public int modifyCourse(Course course);
	public int removeCourseByIds(String ids);
}
