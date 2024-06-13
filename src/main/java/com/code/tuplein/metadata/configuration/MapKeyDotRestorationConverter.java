package com.code.tuplein.metadata.configuration;

import com.code.tuplein.metadata.entity.Asset;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Map;
import java.util.stream.Collectors;

@ReadingConverter
public class MapKeyDotRestorationConverter implements Converter<Document, Asset> {
    @Override
    public Asset convert(Document document) {
        return new Asset();
    }

    private Map<String, String> convertMap(Map<String, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().replace("_", "."),
                        Map.Entry::getValue
                ));
    }
}