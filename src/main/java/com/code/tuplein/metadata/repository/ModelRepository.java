package com.code.tuplein.metadata.repository;

import com.code.tuplein.metadata.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepository extends MongoRepository<Model, String> {

     /*  @Query(value = "{}", fields = "{ 'classes': 1 }")
    List<ClazzDto> findClasses();


    @Query(value = "{ 'classAttributes.className': ?0 }", fields = "{ 'classAttributes.attributeName': 1 }")
    List<String> findModelAttributeNamesByClassName(String className);

    @Query(value = "{ 'associations.fromClass': ?0 }", fields = "{ 'associations.name': 1 }")
    List<String> findModelAssociationsByClassName(String className);

    @Query(value = "{ 'attributes.name': { $regex: ?0, $options: 'i' } }", fields = "{ 'attributes.$': 1 }")
    Attribute findModelAttributeByName(String attributeName);

    @Query(value = "{ 'classAttributes.className': ?0, 'classAttributes.attributeName': { $regex: ?1, $options: 'i' } }", fields = "{ 'classAttributes.$': 1 }")
    ClassAttribute findModelClassAttributeByName(String className, String attributeName);

    @Query(value = "{ 'associations.name': { $regex: ?0, $options: 'i' } }", fields = "{ 'associations.$': 1 }")
    Association findModelAssociationByName(String associationName);*/
}
