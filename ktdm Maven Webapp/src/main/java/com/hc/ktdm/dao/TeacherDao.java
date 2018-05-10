package com.hc.ktdm.dao;

import java.util.List;
import java.util.Map;

import com.hc.ktdm.model.Teacher;

public interface TeacherDao {
	public Teacher selectById(int id);
	public Teacher selectByLoginInfo(String name,String password);
	public int insertTeacher(Teacher teacher);
	public int deleteTeacher(Teacher teacher);
	public int updateTeacher(Teacher teacher);
	public List<Teacher> selectAll();
	public List<Teacher> selectByConditions(Map<String, Object> map);
}
