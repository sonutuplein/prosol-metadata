package com.code.tuplein.metadata.common.reference_data_type;

import lombok.Data;

@Data
public class ReferenceDataType {

    private String name;
    private String referenceClass;
    private String label;
    private Boolean isDeprecated;
}
