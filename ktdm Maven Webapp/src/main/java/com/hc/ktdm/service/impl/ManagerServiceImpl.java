package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.model.Manager;
import com.hc.ktdm.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	@Override
	public Manager findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager findByLoginInfo(String name, String password) {
		
		return managerDao.selectByLoginInfo(name, password);
	}

	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeManager(Manager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyManager(Manager manager) {
		// TODO Auto-generated method stub

	}

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

}
