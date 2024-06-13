package com.code.tuplein.metadata.entity;


import com.code.tuplein.metadata.common.CommonEntity;
import com.code.tuplein.metadata.common.association.Association;
import com.code.tuplein.metadata.common.association_attributes.AssociationAttribute;
import com.code.tuplein.metadata.common.association_kinds.AssociationKind;
import com.code.tuplein.metadata.common.attributes.Attribute;
import com.code.tuplein.metadata.common.class_attributes.ClassAttribute;
import com.code.tuplein.metadata.common.clazz.Clazz;
import com.code.tuplein.metadata.common.data_types.DataType;
import com.code.tuplein.metadata.common.reference_data_type.ReferenceDataType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("models")
public class Model extends CommonEntity {

    @Id
    private String id;

    @Field("required_packages")
    private List<String> requiredPackages;

    @Field("classes")
    private List<Clazz> classes;

    @Field("data_types")
    private List<DataType> dataTypes;

    @Field("attributes")
    private List<Attribute> attributes;

    @Field("class_attributes")
    private List<ClassAttribute> classAttributes;

    @Field("associations")
    private List<Association> associations;

    @Field("association_attributes")
    private List<AssociationAttribute> associationAttributes;

    @Field("association_kinds")
    private List<AssociationKind> associationKinds;

    @Field("reference_data_types")
    private List<ReferenceDataType> referenceDataTypes;
}
