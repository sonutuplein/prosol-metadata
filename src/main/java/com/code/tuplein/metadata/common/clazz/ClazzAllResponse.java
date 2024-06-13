package com.code.tuplein.metadata.common.clazz;

import java.util.List;

public record ClazzAllResponse(List<ClazzDto> classes, int totalCount) {
}
