package com.myspingbootapp.persistence.repositories.specific;

import com.myspingbootapp.domain.model.ArticleOrderRow;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleOrderRowRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Long save(ArticleOrderRow articleOrder) {
		return (Long) this.sessionFactory.getCurrentSession().save(articleOrder);
	}

	public ArticleOrderRow getArticleOrderById(Long id) {

		return this.sessionFactory.getCurrentSession().get(ArticleOrderRow.class, id);
	}
	
	public Integer count() {
		return this.sessionFactory.getCurrentSession().createCriteria(ArticleOrderRow.class).list().size();
	}

	public void update(ArticleOrderRow ArticleOrder) {
		sessionFactory.getCurrentSession().update(ArticleOrder);
	}

}
