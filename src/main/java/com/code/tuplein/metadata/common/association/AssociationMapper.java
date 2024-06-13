package com.code.tuplein.metadata.common.association;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociationMapper {

    Association toEntity(AssociationDto associationDto);

    AssociationDto toResponse(Association association);

}
