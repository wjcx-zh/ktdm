package com.hc.ktdm.service;

import com.hc.ktdm.model.Student;

public interface StudentService {
	public Student findById(int id);
	public Student findBySignUpInfo(String name,String snum);
	public void addStudent(Student student);
	public void removeStudent(Student student);
	public void modifyStudent(Student student);
	
}
