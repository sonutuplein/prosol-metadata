package com.code.tuplein.metadata.repository;

import com.code.tuplein.metadata.entity.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends MongoRepository<Asset, String> {

}
