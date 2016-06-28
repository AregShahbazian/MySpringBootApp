package com.myspingbootapp.persistence;

import com.myspingbootapp.domain.model.DomainEntitySimple;

public interface IDomainEntityRepository {

    void save(DomainEntitySimple domainEntitySimple);

}
