package com.myspingbootapp.persistence;

import com.myspingbootapp.domain.model.DomainEntitySimple;

public interface IDomainEntitySimpleRepository {

	Integer save(DomainEntitySimple domainEntitySimple);

    DomainEntitySimple getDomainEntitySimpleById(Integer id);
    
    void update(DomainEntitySimple domainEntitySimple);
    
}
