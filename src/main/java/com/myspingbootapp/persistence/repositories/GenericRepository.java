package com.myspingbootapp.persistence.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GenericRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public <T> Long save(T object) {
		return (Long) this.sessionFactory.getCurrentSession().save(object);
	}

	public <T> T getObjectById(Long id, Class<T> entityType) {

		return this.sessionFactory.getCurrentSession().get(entityType, id);
	}

	public <T> Integer count(Class<T> entityType) {
		return this.sessionFactory.getCurrentSession().createCriteria(entityType).list().size();
	}

	public <T> void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}
}
