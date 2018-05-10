package com.hc.ktdm.service.impl;

import java.util.List;

import com.hc.ktdm.dao.StudentDao;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.model.Student;
import com.hc.ktdm.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	@Override
	public Student findById(int id) {
		
		return studentDao.selectById(id);
	}

	@Override
	public int addStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	

	@Override
	public int removeStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	@Override
	public int modifyStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student findBySignUpInfo(String name, String snum) {
		return null;
	}
	

	@Override
	public List<Student> findAll() {
		
		return studentDao.selectAll();
	}

	@Override
	public int removeByIds(String ids) {
		String[] id=ids.split(",");
		boolean flag=false;
		int ret=0;
		for(String sid:id){
			Student stu=studentDao.selectById(Integer.parseInt(sid));
			ret=studentDao.deleteStudent(stu);
			
		}
		if(ret!=0){
			flag=true;
		}
		return flag?ids.length():0;
	}
		
	

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	

}
