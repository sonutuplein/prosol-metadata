package com.code.tuplein.metadata.common.clazz;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClazzMapper {

    Clazz toEntity(ClazzDto clazzDto);

    ClazzDto toResponse(Clazz clazz);

}
