package com.myspingbootapp.persistence;

import com.myspingbootapp.domain.model.DomainEntityHierarchical;

public interface IDomainEntityHierarchicalRepository
{

    void save(DomainEntityHierarchical domainEntityHierarchical);

}
