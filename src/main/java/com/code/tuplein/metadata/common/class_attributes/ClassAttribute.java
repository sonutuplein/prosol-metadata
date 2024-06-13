package com.code.tuplein.metadata.common.class_attributes;

import lombok.Data;

@Data
public class ClassAttribute {

    private String className;
    private String attributeName;
    private Boolean isRequired;
    private Boolean isDeprecated;
}
