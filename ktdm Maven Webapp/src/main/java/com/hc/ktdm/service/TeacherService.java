package com.hc.ktdm.service;

import com.hc.ktdm.model.Teacher;

public interface TeacherService {
	public Teacher findById(int id);
	public Teacher findByLoginInfo(String name,String password);
	public void addTeacher(Teacher teacher);
	public void removeTeacher(Teacher teacher);
	public void modifyTeacher(Teacher teacher);
}
