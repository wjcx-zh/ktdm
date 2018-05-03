package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.StudentDao;

import com.hc.ktdm.service.SignUpService;

public class SignUpServiceImpl implements SignUpService {
	private StudentDao studentDao;
	@Override
	public int Exists(String name, int snum,int cid) {
		// TODO Auto-generated method stub
		return studentDao.selectBySignUpInfo(name, snum,cid);
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	

}
