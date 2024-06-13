package com.code.tuplein.metadata.common.association_kinds;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociationKindMapper {

    AssociationKind toEntity(AssociationKindDto request);

    AssociationKindDto toResponse(AssociationKind associationKind);
}
