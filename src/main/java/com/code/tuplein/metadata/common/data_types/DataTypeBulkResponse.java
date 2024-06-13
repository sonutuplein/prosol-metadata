package com.code.tuplein.metadata.common.data_types;

import java.util.List;

public record DataTypeBulkResponse(List<DataTypeDto> dataTypes, int totalCount) {
}
