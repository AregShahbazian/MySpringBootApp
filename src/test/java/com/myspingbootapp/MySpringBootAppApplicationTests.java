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
import com.myspingbootapp.persistence.hibernate.ArticleOrderRowRepository;
import com.myspingbootapp.persistence.hibernate.ArticleRepository;
import com.myspingbootapp.persistence.hibernate.ArticleOrderRepository;
import com.myspingbootapp.persistence.hibernate.UserRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MySpringBootAppApplication.class)
@WebAppConfiguration
@Transactional
@Rollback(false) // Don't roll back transactions (database changes);
public class MySpringBootAppApplicationTests extends TestCase {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ArticleRepository artikelRepository;

	@Autowired
	ArticleOrderRowRepository artikelOrderRowRepository;

	@Autowired
	ArticleOrderRepository artikelOrderRepository;

	//@Test
	public void insertUser() {

		int countBefore = userRepository.count();

		User areg = new User();
		areg.setUsername("Areg");
		userRepository.save(areg);

		int countAfter = userRepository.count();

		assertEquals(countAfter, countBefore + 1);

	}

	@Test
	public void insertArticleOrder() {

		int countBefore = artikelOrderRepository.count();

		User areg = new User();
		areg.setUsername("Areg");
		userRepository.save(areg);

		Article article = new Article();
		article.setTitle("Article 1");
		article.setOwner(areg);

		ArticleOrder articleOrder = new ArticleOrder();
		articleOrder.setUser(areg);

		ArticleOrderRow articleOrderRow = new ArticleOrderRow();
		articleOrderRow.setArticle(article);
		articleOrderRow.setAmount(3);
		articleOrderRow.setOrder(articleOrder);


		artikelRepository.save(article);
		artikelOrderRepository.save(articleOrder);
		artikelOrderRowRepository.save(articleOrderRow);
		
		int countAfter = artikelOrderRepository.count();

		assertTrue(userRepository.count() == 1);
		assertTrue(artikelRepository.count() == 1);
		assertTrue(artikelOrderRepository.count() == 1);
		assertTrue(artikelOrderRowRepository.count() == 1);
		//assertEquals(countAfter, countBefore + 1);

	}


}
