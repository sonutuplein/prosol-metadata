package com.code.tuplein.metadata.service.impl;

import com.code.tuplein.metadata.common.association.Association;
import com.code.tuplein.metadata.common.attributes.Attribute;
import com.code.tuplein.metadata.common.class_attributes.ClassAssociation;
import com.code.tuplein.metadata.common.class_attributes.ClassAttribute;
import com.code.tuplein.metadata.common.class_attributes.ClassField;
import com.code.tuplein.metadata.common.clazz.ClazzAllResponse;
import com.code.tuplein.metadata.common.clazz.ClazzDto;
import com.code.tuplein.metadata.common.clazz.ClazzMapper;
import com.code.tuplein.metadata.entity.Model;
import com.code.tuplein.metadata.mapper.ModelMapper;
import com.code.tuplein.metadata.repository.ModelRepository;
import com.code.tuplein.metadata.request.ModelRequest;
import com.code.tuplein.metadata.response.ModelAllResponse;
import com.code.tuplein.metadata.response.ModelResponse;
import com.code.tuplein.metadata.service.CommonQueryService;
import com.code.tuplein.metadata.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final CommonQueryService commonQueryService;
    private final ModelMapper modelMapper;
    private final ClazzMapper clazzMapper;

    @Override
    public void createModel(ModelRequest modelRequest) {
        Model model = modelMapper.toEntity(modelRequest);
        modelRepository.save(model);
    }

    @Override
    public boolean isModelDataPresent() {
        return modelRepository.count() > 0;
    }

    @Override
    public ModelAllResponse findAllModels() {
        List<ModelResponse> modelResponses = modelRepository.findAll().stream()
                .map(modelMapper::toResponse)
                .toList();
        return new ModelAllResponse(modelResponses, modelResponses.size());
    }

    @Override
    public ClazzAllResponse findClasses() {
        List<ClazzDto> classes = commonQueryService.findModelClasses().stream()
                .map(clazzMapper::toResponse).toList();
        return new ClazzAllResponse(classes, classes.size());
    }


    @Override
    public List<ClassField> findClassFieldsByClassName(String className) {
        List<String> attributeNames = findAttributeNamesByClassName(className);
        return attributeNames.stream()
                .map(attributeName -> {
                    Attribute attribute = findAttributeByName(attributeName);
                    if (attribute == null) {
                        return null;
                    }
                    ClassAttribute classAttribute = findClassAttributeByName(className, attributeName);
                    return new ClassField(attributeName,
                            attribute.getLabel(),
                            classAttribute.getIsRequired(),
                            attribute.getDataType(),
                            attribute.getIsMultiValued());
                })
                .filter(Objects::nonNull)
                .toList();
    }

    private List<String> findAttributeNamesByClassName(String className) {
        List<String> modelAttributeNames = commonQueryService.findModelAttributeNamesByClassName(className);
        if (!modelAttributeNames.isEmpty()) {
            List<String> coreAttributeNames = commonQueryService.findCoreAttributeNamesByClassName("core.object");
            return Stream.concat(coreAttributeNames.stream(),
                            modelAttributeNames.stream())
                    .toList();
        }
        return Collections.emptyList();
    }

    private Attribute findAttributeByName(String attributeName) {
        String simpleAttributeName = attributeName.substring(attributeName.lastIndexOf('.') + 1);
        Attribute coreAttribute = commonQueryService.findCoreAttributeByName(simpleAttributeName);
        Attribute modelAttribute = commonQueryService.findModelAttributeByName(simpleAttributeName);
        if (coreAttribute != null) {
            return coreAttribute;
        }
        return modelAttribute;
    }

    @Override
    public List<ClassAssociation> findClassAssociationsByClassName(String className) {
        List<String> associationNames = findAllAssociations(className);
        return associationNames.stream()
                .map(associationName -> {
                    Association association = findAssociationByName(associationName);
                    ClassAttribute classAttribute = findClassAttributeByName(className, associationName);
                    return new ClassAssociation(classAttribute.getAttributeName(),
                            association.getLabel(),
                            association.getToLabel(),
                            association.getToClass(),
                            association.getFromClass(),
                            association.getDependsOn(),
                            classAttribute.getIsRequired());
                })
                .toList();
    }

    private ClassAttribute findClassAttributeByName(String className, String attributeName) {
        ClassAttribute coreClassAttribute = commonQueryService.findCoreClassAttributeByName(attributeName);
        if (coreClassAttribute != null) {
            return coreClassAttribute;
        }
        return commonQueryService.findModelClassAttributeByName(className, attributeName);
    }


    private List<String> findAllAssociations(String className) {
        return commonQueryService.findModelAssociationsByClassName(className);
    }

    private Association findAssociationByName(String associationName) {
        return commonQueryService.findModelAssociationByName(associationName);
    }
}
