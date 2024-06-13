package com.code.tuplein.metadata.common.attributes;

public record AttributeDto(String name,
                           String label,
                           String dataType,
                           String description,
                           Boolean isMultiValued,
                           Boolean isDeprecated,
                           Boolean isDerived,
                           Boolean isData) {

}
