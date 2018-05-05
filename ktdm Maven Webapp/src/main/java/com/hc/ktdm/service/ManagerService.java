package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Manager;

public interface ManagerService {
	public User findById(int id);
	public Manager findByLoginInfo(String name,String password);
	public List<User> findByConditions(String name,String sex,Integer from,Integer to);
	public int addManager(Manager manager);
	public int removeManager(int id);
	public int removeManagers(List<Integer> ids);
	public int modifyManager(Manager manager);
	public List<User> findAll();
}
