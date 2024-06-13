package com.code.tuplein.metadata.common.attributes;

import java.util.List;

public record AttributeBulkResponse(List<AttributeDto> attributes, int totalCount) {
}
