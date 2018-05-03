package com.hc.ktdm.service;

import com.hc.ktdm.model.Course;

public interface CourseService {
	public Course findById(int id);
	//public Course findByLoginInfo(String name,String password);
	public void addCourse(Course course);
	public void removeCourse(Course course);
	public void modifyCourse(Course course);
}
