package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.Article;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Long save(Article article) {
		return (Long) this.sessionFactory.getCurrentSession().save(article);
	}

	public Article getArticleById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Article.class, id);
	}
	
	public Integer count() {
		return this.sessionFactory.getCurrentSession().createCriteria(Article.class).list().size();
	}

	public void update(Article article) {
		sessionFactory.getCurrentSession().update(article);
	}

}
