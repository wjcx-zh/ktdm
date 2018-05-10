package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Teacher;

public interface TeacherService {
	public User findById(int id);
	public Teacher findByLoginInfo(String name,String password);
	public int addTeacher(Teacher teacher);
	public int removeTeacher(Teacher teacher);
	public int modifyTeacher(Teacher teacher);
	public List<User> findAll();
	public List<User> findByConditions(String name, String sex, Integer from, Integer to);
	public int removeTeacher(int id);
	public int removeTeachers(List<Integer> lists);
}
