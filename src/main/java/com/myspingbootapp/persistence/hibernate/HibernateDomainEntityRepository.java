package com.myspingbootapp.persistence.hibernate;

import com.myspingbootapp.domain.model.DomainEntitySimple;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.myspingbootapp.persistence.IDomainEntitySimpleRepository;

@Repository
@Transactional
public class HibernateDomainEntityRepository implements IDomainEntitySimpleRepository
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer save(DomainEntitySimple domainEntitySimple)
	{
		return (Integer) this.sessionFactory.getCurrentSession().save(domainEntitySimple);
	}

	@Override
	public DomainEntitySimple getDomainEntitySimpleById(Integer id) {

		return this.sessionFactory.getCurrentSession().get(DomainEntitySimple.class, id);
	}

	@Override
	public void update(DomainEntitySimple domainEntitySimple) {
		sessionFactory.getCurrentSession().update(domainEntitySimple);
	}
	
	
}
