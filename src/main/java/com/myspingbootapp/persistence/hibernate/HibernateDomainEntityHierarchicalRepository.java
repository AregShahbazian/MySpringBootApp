package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.DomainEntityHierarchical;
import com.myspingbootapp.persistence.IDomainEntityHierarchicalRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateDomainEntityHierarchicalRepository implements IDomainEntityHierarchicalRepository
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DomainEntityHierarchical domainEntityHierarchical)
	{
		this.sessionFactory.getCurrentSession().save(domainEntityHierarchical);
	}
}
