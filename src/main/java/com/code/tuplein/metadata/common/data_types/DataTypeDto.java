package com.code.tuplein.metadata.common.data_types;

import java.util.List;

public record DataTypeDto(String constraintType,
                          String coreType,
                          String name,
                          Boolean isDeprecated,
                          String fromStart,
                          String toEnd,
                          String regex,
                          String javaClass,
                          List<String> values) {
}
