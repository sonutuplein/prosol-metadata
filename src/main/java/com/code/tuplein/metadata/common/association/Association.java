package com.code.tuplein.metadata.common.association;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Association {

    private String name;
    private String label;
    private String description;
    private String fromClass;
    private String fromLabel;
    private String toClass;
    private String toLabel;
    private String dependsOn;

    @Field("association_kinds")
    private List<String> associationKinds;

    private Boolean isDeprecated;
    private Boolean isUnidirectional;
    private Boolean isAggregate;
}
