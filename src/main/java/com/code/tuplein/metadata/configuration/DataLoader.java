package com.code.tuplein.metadata.configuration;

import com.code.tuplein.metadata.request.CoreRequest;
import com.code.tuplein.metadata.request.ModelRequest;
import com.code.tuplein.metadata.service.CoreService;
import com.code.tuplein.metadata.service.ModelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader {

    private final ApplicationContext context;

    private final CoreService coreService;
    private final ModelService modelService;

    @PostConstruct
    public void init() throws IOException {
        // Check and process the first JSON if necessary
        if (!coreService.isCoreDataPresent()) {
            loadData("classpath:core.json", CoreRequest.class, coreService::createCore);
        } else {
            log.info("Core data already present in the database, skipping core.json");
        }

        // Check and process the second JSON if necessary
        if (!modelService.isModelDataPresent()) {
            loadData("classpath:model.json", ModelRequest.class, modelService::createModel);
        } else {
            log.info("Model data already present in the database, skipping model.json");
        }
    }

    private <T> void loadData(String resourcePath, Class<T> classType, Consumer<T> serviceMethod) throws IOException {
        Resource resource = context.getResource(resourcePath);
        String fileName = resource.getFilename();
        try {
            log.info("Reading file: {}", fileName);
            T request = new ObjectMapper().readValue(resource.getInputStream(), classType);
            serviceMethod.accept(request);
            log.info("Successfully processed data from file: {}", fileName);
        } catch (PropertyBindingException ex) {
            log.error("Error while reading file '{}': wrong JSON format", fileName, ex);
        }
    }
}
