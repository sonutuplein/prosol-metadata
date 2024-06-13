package com.code.tuplein.metadata.controller;

import com.code.tuplein.metadata.common.class_attributes.ClassAssociation;
import com.code.tuplein.metadata.common.class_attributes.ClassField;
import com.code.tuplein.metadata.common.clazz.ClazzAllResponse;
import com.code.tuplein.metadata.response.ModelAllResponse;
import com.code.tuplein.metadata.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/model")
@CrossOrigin(origins = "*")
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public ResponseEntity<ModelAllResponse> getAllModels() {
        ModelAllResponse modelAllResponse = modelService.findAllModels();
        if (modelAllResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(modelAllResponse);
    }

    @GetMapping("/classes")
    public ResponseEntity<ClazzAllResponse> getClasses() {
        ClazzAllResponse clazzAllResponse = modelService.findClasses();
        if (clazzAllResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clazzAllResponse);
    }


    @GetMapping("/{className}/attributes")
    public ResponseEntity<List<ClassField>> getFieldsByClassName(@PathVariable String className) {
        List<ClassField> fields = modelService.findClassFieldsByClassName(className);
        if (fields == null || fields.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(fields);
    }

    @GetMapping("/{className}/associations")
    public ResponseEntity<List<ClassAssociation>> getAssociationsByClassName(@PathVariable String className) {
        List<ClassAssociation> associationNames = modelService.findClassAssociationsByClassName(className);
        if (associationNames == null || associationNames.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(associationNames);
    }
}
