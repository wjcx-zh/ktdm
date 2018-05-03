package com.hc.ktdm.service.impl;

import java.util.List;

import com.hc.ktdm.dao.NameTableDao;
import com.hc.ktdm.model.NameTable;
import com.hc.ktdm.service.NameTableService;

public class NameTableServiceImpl implements NameTableService {
	private NameTableDao nameTableDao;
	
	@Override
	public void addToTable(NameTable nameTable) {
		nameTableDao.insertIntoSignupTable(nameTable);
	}
	@Override
	public List<NameTable> findAllInfo() {
		
		return nameTableDao.selectAll();
	}
	
	@Override
	public int removeAllInfo() {
		
		return nameTableDao.deleteAll();
	}
	
	@Override
	public boolean Exists(String name, int snum) {
		if(nameTableDao.selectBySignUpCondition(name,snum)){
			return true;
		}
		return false;
	}
	
	public NameTableDao getNameTableDao() {
		return nameTableDao;
	}

	public void setNameTableDao(NameTableDao nameTableDao) {
		this.nameTableDao = nameTableDao;
	}
	
	
}
