package com.code.tuplein.metadata.common.attributes;

import lombok.Data;

@Data
public class Attribute {

    private String name;
    private String label;
    private String dataType;
    private String description;
    private Boolean isMultiValued;
    private Boolean isDeprecated;
    private Boolean isDerived;
    private Boolean isData;
}
