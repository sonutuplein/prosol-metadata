package com.code.tuplein.metadata.configuration;

import com.code.tuplein.metadata.entity.Asset;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.util.Map;
import java.util.stream.Collectors;

@WritingConverter
public class MapKeyDotReplacementConverter implements Converter<Asset, Document> {
    @Override
    public Document convert(Asset asset) {
        return new Document();
    }

    private Map<String, String> convertMap(Map<String, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().replace(".", "_"),
                        Map.Entry::getValue
                ));
    }
}