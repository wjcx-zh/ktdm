package com.hc.ktdm.dao;

import com.hc.ktdm.model.Manager;

public interface ManagerDao {
	public Manager selectById(int id);
	public Manager selectByLoginInfo(String name,String password);
	public void insertManager(Manager manager);
	public void deleteManager(Manager manager);
	public void updateManager(Manager manager);
}
