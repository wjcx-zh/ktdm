package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.TeacherDao;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.LoginService;

public class TeacherLoginServiceImpl implements LoginService<Teacher> {
	private TeacherDao teacherDao;
	@Override
	public Teacher Exists(String name,String password) {
		
		return teacherDao.selectByLoginInfo(name, password);
	}

	

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	

}
