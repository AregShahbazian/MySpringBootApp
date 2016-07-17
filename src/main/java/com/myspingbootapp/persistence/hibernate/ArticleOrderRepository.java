package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.ArticleOrder;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleOrderRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Long save(ArticleOrder order) {
		return (Long) this.sessionFactory.getCurrentSession().save(order);
	}

	public ArticleOrder getOrderById(Long id) {

		return this.sessionFactory.getCurrentSession().get(ArticleOrder.class, id);
	}
	
	public Integer count() {
		return this.sessionFactory.getCurrentSession().createCriteria(ArticleOrder.class).list().size();
	}

	public void update(ArticleOrder Order) {
		sessionFactory.getCurrentSession().update(Order);
	}

}
