package com.code.tuplein.metadata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Data
@Document("assets")
public class Asset {

    @Id
    private String id;
    private String assetName;

    @Field("attributes")
    private Map<String, String> attributes;
}
