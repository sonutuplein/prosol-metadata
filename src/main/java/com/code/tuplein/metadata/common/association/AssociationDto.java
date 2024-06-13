package com.code.tuplein.metadata.common.association;

import java.util.List;

public record AssociationDto(String name,
                             String label,
                             String description,
                             String fromClass,
                             String fromLabel,
                             String toClass,
                             String toLabel,
                             String dependsOn,
                             List<String> associationKinds,
                             Boolean isDeprecated,
                             Boolean isUnidirectional,
                             Boolean isAggregate) {

}
