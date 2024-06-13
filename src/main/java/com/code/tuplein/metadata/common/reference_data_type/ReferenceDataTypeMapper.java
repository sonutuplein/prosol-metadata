package com.code.tuplein.metadata.common.reference_data_type;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReferenceDataTypeMapper {

    ReferenceDataType toEntity(ReferenceDataTypeDto referenceDataTypeDto);

    ReferenceDataTypeDto toResponse(ReferenceDataType referenceDataType);
}