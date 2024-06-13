package com.code.tuplein.metadata.common.class_attributes;

public record ClassField(String name,
                         String label,
                         Boolean isRequired,
                         String dataType,
                         Boolean isMultivalued) {
}
