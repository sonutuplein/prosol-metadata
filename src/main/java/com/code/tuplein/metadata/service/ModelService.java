package com.code.tuplein.metadata.service;

import com.code.tuplein.metadata.common.class_attributes.ClassAssociation;
import com.code.tuplein.metadata.common.class_attributes.ClassField;
import com.code.tuplein.metadata.common.clazz.ClazzAllResponse;
import com.code.tuplein.metadata.request.ModelRequest;
import com.code.tuplein.metadata.response.ModelAllResponse;

import java.util.List;

public interface ModelService {

    void createModel(ModelRequest modelRequest);

    boolean isModelDataPresent();

    ModelAllResponse findAllModels();

    ClazzAllResponse findClasses();

    List<ClassField> findClassFieldsByClassName(String className);

    List<ClassAssociation> findClassAssociationsByClassName(String className);
}
