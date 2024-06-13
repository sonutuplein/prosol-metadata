package com.code.tuplein.metadata.common.clazz;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("classes")
public class Clazz {

    private String id;
    private String name;
    private String label;
    private String description;
    private Boolean isFirstClass;

    @Field("super_classes")
    private List<String> superClasses;
    private Boolean isDeprecated;
}
