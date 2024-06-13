package com.code.tuplein.metadata.mapper;

import com.code.tuplein.metadata.request.AssetRequest;
import com.code.tuplein.metadata.response.AssetResponse;
import com.code.tuplein.metadata.entity.Asset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssetMapper {

	@Mapping(target = "id", ignore = true)
    Asset toEntity(AssetRequest request);

	AssetResponse toResponse(Asset asset);
}
