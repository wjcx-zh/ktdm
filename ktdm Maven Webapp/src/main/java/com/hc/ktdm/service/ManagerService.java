package com.hc.ktdm.service;

import com.hc.ktdm.model.Manager;

public interface ManagerService {
	public Manager findById(int id);
	public Manager findByLoginInfo(String name,String password);
	public void addManager(Manager manager);
	public void removeManager(Manager manager);
	public void modifyManager(Manager manager);
}
