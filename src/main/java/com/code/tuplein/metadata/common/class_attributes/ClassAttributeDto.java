package com.code.tuplein.metadata.common.class_attributes;

public record ClassAttributeDto(String className,
                                String attributeName,
                                Boolean isRequired,
                                Boolean isDeprecated) {
}
