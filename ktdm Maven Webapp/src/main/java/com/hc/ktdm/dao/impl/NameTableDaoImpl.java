package com.hc.ktdm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.NameTableDao;
import com.hc.ktdm.model.NameTable;

public class NameTableDaoImpl implements NameTableDao {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insertIntoSignupTable(NameTable nameTable) {
		sessionFactory.getCurrentSession().save(nameTable);
	}
	@Override
	public List<NameTable> selectAll() {
		String hql="from NameTable";
		// sessionFactory.getCurrentSession().createQuery(hql).list();
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public int deleteAll() {
		List<NameTable> nameTables=selectAll();
		List<Integer> ids=new ArrayList<Integer>();
		if(nameTables!=null&&nameTables.size()!=0){
			for(NameTable table:nameTables){
				ids.add(table.getId());
				sessionFactory.getCurrentSession().delete(table);
				sessionFactory.getCurrentSession().evict(table);
			}
		}
		for(int i:ids){
			System.out.println(i);
		}
		System.out.println(ids!=null&&ids.size()!=0);
		/*if(ids!=null&&ids.size()!=0){
			String hql="delete from NameTable where id >0";
			sessionFactory.getCurrentSession().createQuery(hql);
			System.out.println(hql);
			return 1;
		}*/
		return 0;
	}
	@Override
	public boolean selectBySignUpCondition(String name, int snum) {
		String hql="from NameTable where sname=:name and snum=:num";
		NameTable table=(NameTable)sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name)
					.setParameter("num", snum).uniqueResult();
		if(table!=null){
			return true;
		}
		return false;
	}

}
