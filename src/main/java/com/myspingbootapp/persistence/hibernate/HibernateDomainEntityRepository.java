package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.DomainEntitySimple;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.myspingbootapp.persistence.IDomainEntityRepository;

@Repository
@Transactional
public class HibernateDomainEntityRepository implements IDomainEntityRepository
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DomainEntitySimple domainEntitySimple)
	{
		this.sessionFactory.getCurrentSession().save(domainEntitySimple);
	}
}
