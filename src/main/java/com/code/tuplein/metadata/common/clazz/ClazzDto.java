package com.code.tuplein.metadata.common.clazz;

import java.util.List;

public record ClazzDto(String name,
                       String label,
                       String description,
                       Boolean isFirstClass,
                       List<String> superClasses,
                       Boolean isDeprecated) {
}
