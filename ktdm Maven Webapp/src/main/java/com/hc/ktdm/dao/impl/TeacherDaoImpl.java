package com.hc.ktdm.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.hc.ktdm.dao.TeacherDao;
import com.hc.ktdm.model.Teacher;

public class TeacherDaoImpl implements TeacherDao{
	private SessionFactory sessionFactory;
	@Override
	public Teacher selectById(int id) {
		
		return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class, id);
	}


	@Override
	public Teacher selectByLoginInfo(String name, String password) {
		String hql="from Teacher where tname= :name and password= :pass";
		Teacher t=(Teacher) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("pass", password).uniqueResult();
		System.out.println(t);
		return t;
	}
	@Override
	public int insertTeacher(Teacher teacher) {
		Integer result=(Integer) sessionFactory.getCurrentSession().save(teacher);
		return result>0?1:0;
	}

	@Override
	public int deleteTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().delete(teacher);
		return 1;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().update(teacher);
		return 1;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Teacher> selectAll() {
		String hql="from Teacher";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}


	@Override
	public List<Teacher> selectByConditions(Map<String, Object> map) {
		Set<String> set=map.keySet();
		return getHqlQuery(set, map);
	}


	private List<Teacher> getHqlQuery(Set<String> set, Map<String, Object> map) {
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


	private String getDynamicHqlBySelectConditions(Set<String> set) {
		StringBuffer hql=new StringBuffer("from Teacher ");
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


}
