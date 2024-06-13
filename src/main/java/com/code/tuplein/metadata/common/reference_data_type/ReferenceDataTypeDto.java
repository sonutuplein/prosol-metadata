package com.code.tuplein.metadata.common.reference_data_type;

public record ReferenceDataTypeDto(String name,
                                   String referenceClass,
                                   String label,
                                   Boolean isDeprecated) {
}