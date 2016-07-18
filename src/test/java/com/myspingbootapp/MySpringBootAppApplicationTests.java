package com.myspingbootapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.myspingbootapp.domain.model.Article;
import com.myspingbootapp.domain.model.ArticleOrderRow;
import com.myspingbootapp.domain.model.ArticleOrder;
import com.myspingbootapp.domain.model.User;
import com.myspingbootapp.persistence.repositories.GenericRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MySpringBootAppApplication.class)
@WebAppConfiguration
@Transactional
@Rollback(true) // Roll back transactions (database changes);
public class MySpringBootAppApplicationTests extends TestCase {

	@Autowired
	GenericRepository genericRepository;

	@Test
	public void insertUser() {

		User areg = new User();
		areg.setUsername("Areg");
		genericRepository.save(areg);

		assertTrue(genericRepository.count(User.class) == 1);

	}

	@Test
	public void insertArticle() {

		User areg = new User();
		areg.setUsername("Areg");

		Article article = new Article();
		article.setTitle("Article 1");
		article.setOwner(areg);

		// genericRepository.save(areg); // Is implicitly saved by Hibernate
		genericRepository.save(article);

		assertTrue(genericRepository.count(User.class) == 1);
		assertTrue(genericRepository.count(Article.class) == 1);

	}

	@Test
	public void insertArticleOrder() {

		User areg = new User();
		areg.setUsername("Areg");

		Article article = new Article();
		article.setTitle("Article 1");
		article.setOwner(areg);

		ArticleOrder articleOrder = new ArticleOrder();
		articleOrder.setUser(areg);

		ArticleOrderRow articleOrderRow = new ArticleOrderRow();
		articleOrderRow.setArticle(article);
		articleOrderRow.setAmount(3);
		articleOrderRow.setOrder(articleOrder);

		/*
		 * These are implicitly saved by Hibernate
		 */
		// genericRepository.save(areg); 
		// genericRepository.save(article); 
		// genericRepository.save(articleOrder); 
		genericRepository.save(articleOrderRow);

		assertTrue(genericRepository.count(User.class) == 1);
		assertTrue(genericRepository.count(Article.class) == 1);
		assertTrue(genericRepository.count(ArticleOrder.class) == 1);
		assertTrue(genericRepository.count(ArticleOrderRow.class) == 1);
	}

}
