package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Manager;

public interface ManagerService {
	public Manager findById(int id);
	public Manager findByLoginInfo(String name,String password);
	public int addManager(Manager manager);
	public void removeManager(Manager manager);
	public void modifyManager(Manager manager);
	public List<User> findAll();
}
