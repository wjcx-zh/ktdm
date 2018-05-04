package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.model.Manager;
import com.hc.ktdm.service.LoginService;

public class ManagerLoginServiceImpl implements LoginService<Manager> {
	private ManagerDao managerDao;
	@Override
	public Manager Exists(String name, String password) {
		
		return managerDao.selectByLoginInfo(name, password);
	}
	public ManagerDao getManagerDao() {
		return managerDao;
	}
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	
}
