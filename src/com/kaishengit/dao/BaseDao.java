package com.kaishengit.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class BaseDao<T,PK extends Serializable> {

	private SessionFactory sessionFactory;
	private Class<?> clazz;
	
	public BaseDao() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<?>) pt.getActualTypeArguments()[0];
	}
	
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		return (T) getSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public T findByProperty(String propertyName,Object value) {
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.eq(propertyName, value));
		return (T) c.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<T> findListByProperty(String propertyName,Object value) {
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.eq(propertyName, value));
		return c.list();
	}
	
	public void del(T t) {
		getSession().delete(t);
	}
	
	public void del(PK id) {
		getSession().delete(findById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria c = getSession().createCriteria(clazz);
		return c.list();
	}
	
	public void save(T t) {
		getSession().saveOrUpdate(t);
	}
	
	
	
	
	
	
	
	
	
	
	
}
