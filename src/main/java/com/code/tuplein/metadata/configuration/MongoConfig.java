package com.code.tuplein.metadata.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converters = Arrays.asList(
                new MapKeyDotReplacementConverter(),
                new MapKeyDotRestorationConverter()
        );
        return new MongoCustomConversions(converters);
    }
}