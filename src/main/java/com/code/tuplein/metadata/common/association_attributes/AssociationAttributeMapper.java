package com.code.tuplein.metadata.common.association_attributes;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociationAttributeMapper {

    AssociationAttribute toEntity(AssociationAttributeDto associationAttributeDto);

    AssociationAttributeDto toResponse(AssociationAttribute associationAttribute);

}
