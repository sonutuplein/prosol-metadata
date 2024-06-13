package com.code.tuplein.metadata.service;

import com.code.tuplein.metadata.request.AssetRequest;
import com.code.tuplein.metadata.response.AssetBulkResponse;
import com.code.tuplein.metadata.response.AssetResponse;

import java.util.List;

public interface AssetService {

    AssetResponse createAsset(AssetRequest assetRequest);

    AssetBulkResponse saveBulkAsset(List<AssetRequest> assetRequests);

    AssetBulkResponse findAllAssets();

    AssetBulkResponse findAssetByName(String assetName);

    AssetResponse updateAsset(String id, AssetRequest assetRequest);

    AssetResponse deleteAsset(String id);
}
