package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Long save(User user) {
		return (Long) this.sessionFactory.getCurrentSession().save(user);
	}

	public User getUserById(Long id) {

		return this.sessionFactory.getCurrentSession().get(User.class, id);
	}

	public Integer count() {
		return this.sessionFactory.getCurrentSession().createCriteria(User.class).list().size();
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

}
