package com.hc.ktdm.dao;

import java.util.List;

import com.hc.ktdm.model.Manager;

public interface ManagerDao {
	public Manager selectById(int id);
	public Manager selectByLoginInfo(String name,String password);
	public int insertManager(Manager manager);
	public void deleteManager(Manager manager);
	public void updateManager(Manager manager);
	public List<Manager> selectAll();
}
