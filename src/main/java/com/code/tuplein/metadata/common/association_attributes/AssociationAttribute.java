package com.code.tuplein.metadata.common.association_attributes;

import lombok.Data;

@Data
public class AssociationAttribute {

    private String name;
    private String referenceDataType;
    private String associationName;
    private Boolean isRequired;
    private Boolean isDeprecated;
}
