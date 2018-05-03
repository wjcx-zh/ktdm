package com.hc.ktdm.service;

import java.util.List;

import com.hc.ktdm.model.NameTable;

public interface NameTableService {
	public boolean Exists(String name,int snum);
	public void addToTable(NameTable nameTable);
	public List<NameTable> findAllInfo();
	public int removeAllInfo();
}
