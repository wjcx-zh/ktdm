package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.model.Student;

public interface StudentService {
	public Student findById(int id);
	public Student findBySignUpInfo(String name,String snum);
	public int addStudent(Student student);
	public int removeStudent(Student student);
	public int modifyStudent(Student student);
	public List<Student> findAll();
	public int removeByIds(String ids);
	
}
