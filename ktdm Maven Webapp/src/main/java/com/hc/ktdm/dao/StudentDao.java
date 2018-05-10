package com.hc.ktdm.dao;

import java.util.List;

import com.hc.ktdm.model.Student;

public interface StudentDao {
	public Student selectById(int id);
	public int selectBySignUpInfo(String name,int snum,int cid);
	public int insertStudent(Student student);
	public int deleteStudent(Student student);
	public int updateStudent(Student student);
	public List<Student> selectAll();
}
