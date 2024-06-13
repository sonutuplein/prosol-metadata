package com.code.tuplein.metadata.mapper;

import com.code.tuplein.metadata.common.association.AssociationMapper;
import com.code.tuplein.metadata.common.association_attributes.AssociationAttributeMapper;
import com.code.tuplein.metadata.common.association_kinds.AssociationKindMapper;
import com.code.tuplein.metadata.common.attributes.AttributeMapper;
import com.code.tuplein.metadata.common.class_attributes.ClassAttributeMapper;
import com.code.tuplein.metadata.common.clazz.ClazzMapper;
import com.code.tuplein.metadata.common.data_types.DataTypeMapper;
import com.code.tuplein.metadata.common.reference_data_type.ReferenceDataTypeMapper;
import com.code.tuplein.metadata.entity.Model;
import com.code.tuplein.metadata.request.ModelRequest;
import com.code.tuplein.metadata.response.ModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ClazzMapper.class, DataTypeMapper.class, AttributeMapper.class, ClassAttributeMapper.class , AssociationMapper.class, AssociationAttributeMapper.class, AssociationKindMapper.class, ReferenceDataTypeMapper.class})
public interface ModelMapper {

	@Mapping(target = "id", ignore = true)
    Model toEntity(ModelRequest modelRequest);

	ModelResponse toResponse(Model model);
}
