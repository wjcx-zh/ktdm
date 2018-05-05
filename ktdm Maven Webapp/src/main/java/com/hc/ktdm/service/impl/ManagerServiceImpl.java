package com.hc.ktdm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Manager;
import com.hc.ktdm.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	@Override
	public User findById(int id) {
		Manager manager=managerDao.selectById(id);
		if(manager!=null){
			User user=new User(manager.getMid(),manager.getMname(),manager.getSex(),manager.getAge(),manager.getPassword(),null);
			return user;
		}
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
	public int removeManager(int id) {
		Manager man=managerDao.selectById(id);
		return managerDao.deleteManager(man);
	}

	@Override
	public int modifyManager(Manager manager) {
		return managerDao.updateManager(manager);
	}

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public int removeManagers(List<Integer> ids) {
		int result=0;
		for(int id:ids){
			Manager man=managerDao.selectById(id);
			result=managerDao.deleteManager(man);
		}
		return result;
	}

	@Override
	public List<User> findByConditions(String name, String sex, Integer from, Integer to) {
		System.out.println(name+","+sex+","+from+","+to);
		Map<String,Object> map=new HashMap<String,Object>();
		List<User> users=new ArrayList<User>();
		if(name==""){
			name=null;
		}
		if(sex==""){
			sex=null;
		}
		if(name!=null){
			map.put("name", name);
		}
		if(from!=null){
			map.put("from", from);
		}
		if(to!=null){
			map.put("to", to);
		}
		if(sex!=null){
			map.put("sex", sex);
		}
		List<Manager> mans=managerDao.selectByConditions(map);
		if(mans!=null&&mans.size()>0){
			for(Manager man:mans){
				User user=new User(man.getMid(),man.getMname(),man.getSex(),man.getAge(),man.getPassword(),null);
				users.add(user);
			}
			return users;
		}
		
		List<Manager> all=managerDao.selectAll();
		if(all!=null&&all.size()>0){
			for(Manager man:all){
				User user=new User(man.getMid(),man.getMname(),man.getSex(),man.getAge(),man.getPassword(),null);
				users.add(user);
			}
		}
		return users;
	}

	

}
