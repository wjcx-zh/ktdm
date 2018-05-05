package com.hc.ktdm.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hc.ktdm.dao.ManagerDao;
import com.hc.ktdm.model.Manager;


public class ManagerDaoImpl implements ManagerDao{
	private SessionFactory sessionFactory;
	@Override
	public Manager selectById(int id) {
	
		return sessionFactory.getCurrentSession().get(Manager.class, id);
	}
	

	@Override
	public List<Manager> selectAll() {
		String hql="from Manager";
		
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@Override
	public List<Manager> selectByConditions(Map<String, Object> map) {
		Set<String> set=map.keySet();
		/*StringBuffer hql=new StringBuffer("from Manager ");
		if(set.contains("name")){
			hql.append(" where mname=:name");
		}*/
		return getHqlQuery(set, map);
		/*return sessionFactory.getCurrentSession().createQuery(hql.toString()).setParameter("name", map.get("name")).list();*/
	}
	
	@Override
	public Manager selectByLoginInfo(String name, String password) {
		String hql="from Manager where mname= :name and password= :pass";
		Manager m=(Manager) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("pass", password).uniqueResult();
		return m;
	}

	@Override
	public int insertManager(Manager manager) {
		Integer result=(Integer) sessionFactory.getCurrentSession().save(manager);
		return result>0?1:0;
	}

	@Override
	public int deleteManager(Manager manager) {
		sessionFactory.getCurrentSession().delete(manager);
		return 1;
	}

	@Override
	public int updateManager(Manager manager) {
		sessionFactory.getCurrentSession().update(manager);
		return 1;
	}

	private String getDynamicHqlBySelectConditions(Set<String> set){
		StringBuffer hql=new StringBuffer("from Manager ");
		boolean and=false;
		if(set.contains("name")){
			if(!and){
				hql.append(" where mname=:name ");
				and=true;
			}else{
				hql.append(" and mname=:name ");
			}
		}
		if(set.contains("sex")){
			if(!and){
				hql.append(" where sex=:sex ");
				and=true;
			}else{
				hql.append(" and sex=:sex ");
			}
					
		}

		if(set.contains("from")){
			if(!and){
				hql.append(" where age>:from ");
				and=true;
			}else{
				hql.append(" and age>:from ");
			}
				
		}
		if(set.contains("to")){
			if(!and){
				hql.append(" where age<:to ");	
				and=true;
			}else{
				hql.append(" and age<:to ");	
			}
			
		}
		return hql.toString();
	}
	
	private List<Manager> getHqlQuery(Set<String> set,Map<String,Object> map){
		String hql=getDynamicHqlBySelectConditions(set);
		System.out.println(hql);
		if(set.contains("name")&&set.contains("sex")&&set.contains("from")&&set.contains("to")){
			return sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", map.get("name"))
						.setParameter("sex", map.get("sex")).setParameter("from", map.get("from"))
						.setParameter("to", map.get("to")).list();
			
		}else if(set.contains("name")&&set.contains("sex")&&set.contains("from")){
			return sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", map.get("name"))
						.setParameter("sex", map.get("sex")).setParameter("from", map.get("from")).list();
			
		}else if(set.contains("name")&&set.contains("sex")){
			return sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", map.get("name"))
					.setParameter("sex", map.get("sex")).list();
		
		}else if(set.contains("from")&&set.contains("to")){
			return sessionFactory.getCurrentSession().createQuery(hql).setParameter("from", map.get("from"))
					.setParameter("to", map.get("to")).list();
		
		}else if(set.contains("sex")&&set.contains("from")&&set.contains("to")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("sex", map.get("sex")).setParameter("from", map.get("from"))
					.setParameter("to", map.get("to")).list();
		
		}else if(set.contains("sex")&&set.contains("from")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("sex", map.get("sex")).setParameter("from", map.get("from")).list();
		
		}else if(set.contains("sex")&&set.contains("to")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("sex", map.get("sex"))
					.setParameter("to", map.get("to")).list();
		
		}else if(set.contains("sex")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("sex", map.get("sex")).list();
				
		}else if(set.contains("to")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("to", map.get("to")).list();
		}else if(set.contains("from")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("from", map.get("from")).list();
		}else if(set.contains("name")){
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("name", map.get("name")).list();
		}
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
