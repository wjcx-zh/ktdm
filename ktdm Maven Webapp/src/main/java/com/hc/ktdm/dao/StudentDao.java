package com.hc.ktdm.dao;

import com.hc.ktdm.model.Student;

public interface StudentDao {
	public Student selectById(int id);
	public int selectBySignUpInfo(String name,int snum,int cid);
	public void insertStudent(Student student);
	public void deleteStudent(Student student);
	public void updateStudent(Student student);
}
