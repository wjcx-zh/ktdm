package com.hc.ktdm.dao;

import java.util.List;
import java.util.Map;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Manager;

public interface ManagerDao {
	public Manager selectById(int id);
	public Manager selectByLoginInfo(String name,String password);
	public int insertManager(Manager manager);
	public int deleteManager(Manager manager);
	public int updateManager(Manager manager);
	public List<Manager> selectAll();
	public List<Manager> selectByConditions(Map<String, Object> map);
}
