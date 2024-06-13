package com.code.tuplein.metadata.common.class_attributes;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassAttributeMapper {

    ClassAttribute toEntity(ClassAttributeDto request);

    ClassAttributeDto toResponse(ClassAttribute classAttribute);

}
