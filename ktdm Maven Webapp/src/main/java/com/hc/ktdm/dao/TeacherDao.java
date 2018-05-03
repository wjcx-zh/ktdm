package com.hc.ktdm.dao;

import com.hc.ktdm.model.Teacher;

public interface TeacherDao {
	public Teacher selectById(int id);
	public Teacher selectByLoginInfo(String name,String password);
	public void insertTeacher(Teacher teacher);
	public void deleteTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
}
