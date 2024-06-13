package com.code.tuplein.metadata.service;

import com.code.tuplein.metadata.common.association.Association;
import com.code.tuplein.metadata.common.attributes.Attribute;
import com.code.tuplein.metadata.common.class_attributes.ClassAttribute;
import com.code.tuplein.metadata.common.clazz.Clazz;
import com.code.tuplein.metadata.common.data_types.DataType;
import com.code.tuplein.metadata.entity.Asset;
import com.code.tuplein.metadata.entity.Core;
import com.code.tuplein.metadata.entity.Model;
import com.code.tuplein.metadata.repository.AssetRepository;
import com.code.tuplein.metadata.repository.CoreRepository;
import com.code.tuplein.metadata.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonQueryService {

    private final ModelRepository modelRepository;
    private final CoreRepository coreRepository;
    private final AssetRepository assetRepository;

    public List<Model> findAllModels() {
        if (modelRepository != null) {
            return modelRepository.findAll();
        }
        return Collections.emptyList();
    }


    public List<Clazz> findModelClasses() {
        return this.findAllModels().stream()
                .filter(Objects::nonNull)
                .flatMap(model -> model.getClasses().stream())
                .toList();
    }


    public List<String> findModelAttributeNamesByClassName(String className) {
        return this.findAllModels().stream()
                .flatMap(model -> model.getClassAttributes().stream())
                .filter(classAttribute -> classAttribute.getClassName().equals(className))
                .map(ClassAttribute::getAttributeName)
                .toList();

    }

    public List<String> findModelAssociationsByClassName(String className) {
        return this.findAllModels().stream()
                .flatMap(model -> model.getAssociations().stream())
                .filter(association -> association.getFromClass().equals(className))
                .map(Association::getName)
                .toList();
    }

    public Attribute findModelAttributeByName(String attributeName) {
        return this.findAllModels().stream()
                .flatMap(model -> model.getAttributes().stream())
                .filter(attribute -> attribute.getName().contains(attributeName))
                .findFirst()
                .orElse(null);
    }

    public ClassAttribute findModelClassAttributeByName(String className, String attributeName) {
        return this.findAllModels().stream()
                .flatMap(model -> model.getClassAttributes().stream())
                .filter(classAttribute -> classAttribute.getClassName().equals(className) &&
                        classAttribute.getAttributeName().contains(attributeName))
                .findFirst()
                .orElse(null);
    }

    public Association findModelAssociationByName(String associationName) {
        return this.findAllModels().stream()
                .flatMap(model -> model.getAssociations().stream())
                .filter(association -> association.getName().contains(associationName))
                .findFirst()
                .orElse(null);
    }


    public List<Core> findAllCore() {
        return coreRepository.findAll();
    }

    public List<DataType> findCoreDataTypes() {
        Core core = this.findAllCore().stream().findFirst().orElse(null);
        if (core == null) {
            return Collections.emptyList();
        }
        return core.getDataTypes();
    }

    public List<String> findCoreAttributeNamesByClassName(String className) {
        return this.findAllCore().stream()
                .flatMap(core -> core.getClassAttributes().stream())
                .filter(classAttribute -> classAttribute.getClassName().contains(className))
                .map(ClassAttribute::getAttributeName)
                .toList();
    }

    public DataType findCoreDataTypeByName(String dataTypeName) {
        return this.findCoreDataTypes().stream()
                .filter(dataType -> dataType.getName().equals(dataTypeName))
                .findFirst()
                .orElse(null);
    }

    public Attribute findCoreAttributeByName(String attributeName) {
        return this.findAllCore().stream()
                .flatMap(core -> core.getAttributes().stream())
                .filter(attribute -> attribute.getName().contains(attributeName))
                .findFirst()
                .orElse(null);
    }

    public ClassAttribute findCoreClassAttributeByName(String attributeName) {
        return this.findAllCore().stream()
                .flatMap(core -> core.getClassAttributes().stream())
                .filter(classAttribute -> classAttribute.getAttributeName().contains(attributeName))
                .findFirst()
                .orElse(null);
    }

    public List<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    public List<Asset> findAssetsByAssetName(String assetName) {
        return this.findAllAssets().stream()
                .filter(asset -> asset.getAssetName().contains(assetName))
                .toList();
    }
}
