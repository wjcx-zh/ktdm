package com.hc.ktdm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.domain.User;
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
	public List<User> findAll() {
		List<Manager> managers=managerDao.selectAll();
		List<User> users=new ArrayList<User>();
		if(managers!=null&&managers.size()!=0){
			for(Manager m:managers){
				User user=new User(m.getMid(),m.getMname(),m.getSex(),m.getAge(),m.getPassword(),null);
				users.add(user);
			}
			return users;
		}
		return null;
	}
	
	@Override
	public Manager findByLoginInfo(String name, String password) {
		
		return managerDao.selectByLoginInfo(name, password);
	}

	@Override
	public int addManager(Manager manager) {
		
		return managerDao.insertManager(manager);
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
