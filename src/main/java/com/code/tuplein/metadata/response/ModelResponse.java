package com.code.tuplein.metadata.response;

import com.code.tuplein.metadata.common.association.AssociationDto;
import com.code.tuplein.metadata.common.association_attributes.AssociationAttributeDto;
import com.code.tuplein.metadata.common.association_kinds.AssociationKindDto;
import com.code.tuplein.metadata.common.attributes.AttributeDto;
import com.code.tuplein.metadata.common.class_attributes.ClassAttributeDto;
import com.code.tuplein.metadata.common.clazz.ClazzDto;
import com.code.tuplein.metadata.common.data_types.DataTypeDto;
import com.code.tuplein.metadata.common.reference_data_type.ReferenceDataTypeDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelResponse(String id,
                            String packageName,
                            String packageLabel,
                            String packageDescription,
                            String modifiedBy,
                            Boolean isDeprecated,
                            Integer version,
                            List<String> requiredPackages,
                            List<ClazzDto> classes,
                            List<DataTypeDto> dataTypes,
                            List<AttributeDto> attributes,
                            List<ClassAttributeDto> classAttributes,
                            List<AssociationDto> associations,
                            List<AssociationAttributeDto> associationAttributes,
                            List<AssociationKindDto> associationKinds,
                            List<ReferenceDataTypeDto> referenceDataTypes) {

}

