package com.code.tuplein.metadata.common.attributes;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeMapper {

    Attribute toEntity(AttributeDto attributeDto);

    AttributeDto toResponse(Attribute attribute);
}
