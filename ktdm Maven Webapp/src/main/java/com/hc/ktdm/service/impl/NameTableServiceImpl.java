package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.NameTableDao;
import com.hc.ktdm.model.NameTable;
import com.hc.ktdm.service.NameTableService;

public class NameTableServiceImpl implements NameTableService {
	private NameTableDao nameTableDao;
	
	@Override
	public void addToTable(NameTable nameTable) {
		nameTableDao.insertIntoSignupTable(nameTable);
	}

	public NameTableDao getNameTableDao() {
		return nameTableDao;
	}

	public void setNameTableDao(NameTableDao nameTableDao) {
		this.nameTableDao = nameTableDao;
	}

}
