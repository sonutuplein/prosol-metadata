package com.code.tuplein.metadata.service.impl;

import com.code.tuplein.metadata.entity.Asset;
import com.code.tuplein.metadata.mapper.AssetMapper;
import com.code.tuplein.metadata.repository.AssetRepository;
import com.code.tuplein.metadata.request.AssetRequest;
import com.code.tuplein.metadata.response.AssetBulkResponse;
import com.code.tuplein.metadata.response.AssetResponse;
import com.code.tuplein.metadata.service.AssetService;
import com.code.tuplein.metadata.service.CommonQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final CommonQueryService commonQueryService;
    private final AssetMapper assetMapper;


    @Override
    public AssetResponse createAsset(AssetRequest assetRequest) {
        Asset asset = assetMapper.toEntity(assetRequest);
        Asset savedAsset = assetRepository.save(asset);
        return assetMapper.toResponse(savedAsset);
    }

    @Override
    public AssetBulkResponse saveBulkAsset(List<AssetRequest> assetRequests) {
        List<AssetResponse> responses = assetRequests.stream().map(this::createAsset).toList();
        int count = responses.size();
        return new AssetBulkResponse(responses, count);
    }

    @Override
    public AssetBulkResponse findAllAssets() {
        List<AssetResponse> responses = assetRepository.findAll().stream().map(assetMapper::toResponse).toList();
        int count = responses.size();
        return new AssetBulkResponse(responses, count);
    }

    @Override
    public AssetBulkResponse findAssetByName(String assetName) {
        List<AssetResponse> responses = commonQueryService.findAssetsByAssetName(assetName).stream().map(assetMapper::toResponse).toList();
        int count = responses.size();
        return new AssetBulkResponse(responses, count);
    }

    @Override
    public AssetResponse updateAsset(String id, AssetRequest assetRequest) {
        Asset existingAsset = findById(id);
        if (existingAsset != null) {
            existingAsset = assetMapper.toEntity(assetRequest);
            existingAsset.setId(id);
            Asset updatedAsset = assetRepository.save(existingAsset);
            return assetMapper.toResponse(updatedAsset);
        }
        return null;
    }

    @Override
    public AssetResponse deleteAsset(String id) {
        Asset existingAsset = findById(id);
        if (existingAsset != null) {
            assetRepository.delete(existingAsset);
            return assetMapper.toResponse(existingAsset);
        }
        return null;
    }

    private Asset findById(String id) {
        return assetRepository.findById(id).orElse(null);
    }

}
