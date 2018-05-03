package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.TeacherDao;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao;
	@Override
	public Teacher findById(int id) {
		
		return teacherDao.selectById(id);
	}

	@Override
	public Teacher findByLoginInfo(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

}
