package com.code.tuplein.metadata.common.association_attributes;

public record AssociationAttributeDto(String name,
                                      String referenceDataType,
                                      String associationName,
                                      Boolean isRequired,
                                      Boolean isDeprecated) {

}
