package com.code.tuplein.metadata.repository;

import com.code.tuplein.metadata.entity.Core;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreRepository extends MongoRepository<Core, String> {

 /*   @Query(value = "{}", fields = "{ 'dataTypes': 1 }")
    List<DataType> findCoreDataTypes();

    @Query(value = "{ 'classAttributes.className': { $regex: ?0, $options: 'i' } }", fields = "{ 'classAttributes.attributeName': 1 }")
    List<String> findCoreAttributeNamesByClassName(String className);

    @Query(value = "{ 'dataTypes.name': ?0 }", fields = "{ 'dataTypes.$': 1 }")
    DataType findDataTypeByName(String name);

    @Query(value = "{ 'attributes.name': { $regex: ?0, $options: 'i' } }", fields = "{ 'attributes.$': 1 }")
    Attribute findCoreAttributeByName(String attributeName);

    @Query(value = "{ 'classAttributes.attributeName': { $regex: ?0, $options: 'i' } }", fields = "{ 'classAttributes.$': 1 }")
    ClassAttribute findCoreClassAttributeByName(String attributeName);*/
}
