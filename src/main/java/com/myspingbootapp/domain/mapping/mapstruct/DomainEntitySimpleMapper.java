package com.myspingbootapp.domain.mapping.mapstruct;

import com.myspingbootapp.domain.dto.DomainEntitySimpleDTO;
import com.myspingbootapp.domain.model.DomainEntitySimple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
//import org.mapstruct.factory.Mappers;

@Mapper//(componentModel = "spring")
public interface DomainEntitySimpleMapper
{

	DomainEntitySimpleMapper INSTANCE = Mappers.getMapper(DomainEntitySimpleMapper.class);

	@Mappings({
			@Mapping(source = "name", target = "entity_name")})
	DomainEntitySimple domainEntitySimpleDTOToDomainEntitySimple(DomainEntitySimpleDTO domainEntitySimpleDTO);


}
