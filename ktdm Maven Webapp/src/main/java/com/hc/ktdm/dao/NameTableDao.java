package com.hc.ktdm.dao;

import java.util.List;

import com.hc.ktdm.model.NameTable;

public interface NameTableDao {
	public void insertIntoSignupTable(NameTable nameTable);

	public List<NameTable> selectAll();

	public int deleteAll();

	public boolean selectBySignUpCondition(String name, int snum);
}
