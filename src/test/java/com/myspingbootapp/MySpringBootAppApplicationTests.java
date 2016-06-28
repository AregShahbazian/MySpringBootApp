package com.myspingbootapp;

import com.myspingbootapp.domain.model.DomainEntityHierarchical;
import com.myspingbootapp.domain.model.DomainEntitySimple;
import com.myspingbootapp.persistence.IDomainEntityHierarchicalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.myspingbootapp.persistence.IDomainEntityRepository;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MySpringBootAppApplication.class)
@WebAppConfiguration
@Transactional
@Rollback(false)    // Don't roll back transactions (database changes);
public class MySpringBootAppApplicationTests extends TestCase
{

	@Autowired
	IDomainEntityRepository domainEntityRepository;

	@Autowired
	IDomainEntityHierarchicalRepository domainEntityHierarchicalRepository;

	@Test
	public void insertDomainEntity()
	{
		DomainEntitySimple domainEntitySimple = new DomainEntitySimple();
		domainEntitySimple.setEntity_name("Entity nr 1");

		domainEntityRepository.save(domainEntitySimple);

		assertEquals(false, false);

	}

	@Test
	public void insertDomainEntityHierarchical()
	{
		DomainEntityHierarchical domainEntityHierarchical = new DomainEntityHierarchical();
		domainEntityHierarchical.setHierarchical_entity_name("Name of hierarchical entity");

		DomainEntitySimple sub_entity_required = new DomainEntitySimple();
		sub_entity_required.setEntity_name("Name of sub_entity_required");

		DomainEntitySimple sub_entity_optional = new DomainEntitySimple();
		sub_entity_optional.setEntity_name("Name of sub_entity_optional");

		domainEntityHierarchical.setSub_entity_required(sub_entity_required);
		domainEntityHierarchical.setSub_entity_optional(sub_entity_optional);

		domainEntityHierarchicalRepository.save(domainEntityHierarchical);

		assertEquals(false, false);

	}

	@Test
	public void foo()
	{
	
	}

}
