package com.code.tuplein.metadata.common.data_types;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class DataType {

    private String constraintType;
    private String coreType;
    private String name;
    private Boolean isDeprecated;
    private String fromStart;
    private String toEnd;
    private String regex;
    private String javaClass;

    @Field("values")
    private List<String> values;
}
