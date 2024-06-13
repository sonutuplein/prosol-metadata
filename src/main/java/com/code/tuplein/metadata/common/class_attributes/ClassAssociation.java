package com.code.tuplein.metadata.common.class_attributes;

public record ClassAssociation(String name,
                               String label,
                               String toLabel,
                               String toClass,
                               String targetType,
                               String dependsOn,
                               Boolean isRequired) {

}

