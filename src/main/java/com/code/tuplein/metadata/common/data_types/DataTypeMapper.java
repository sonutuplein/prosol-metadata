package com.code.tuplein.metadata.common.data_types;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTypeMapper {

    DataType toEntity(DataTypeDto dataTypeDto);

    DataTypeDto toResponse(DataType dataType);

}
