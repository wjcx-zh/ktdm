package com.hc.ktdm.service.impl;

import com.hc.ktdm.dao.TypeDao;
import com.hc.ktdm.model.Type;
import com.hc.ktdm.service.TypeService;

public class TypeServiceImpl implements TypeService{
	private TypeDao typeDao;
	@Override
	public Type findById(int id) {
		
		return typeDao.selectById(id);
	}
	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

}
