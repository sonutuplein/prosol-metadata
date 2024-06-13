package com.code.tuplein.metadata.controller;

import com.code.tuplein.metadata.request.AssetRequest;
import com.code.tuplein.metadata.response.AssetBulkResponse;
import com.code.tuplein.metadata.response.AssetResponse;
import com.code.tuplein.metadata.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssetController {
    private final AssetService assetService;

    @PostMapping
    public ResponseEntity<AssetResponse> saveAsset(@RequestBody AssetRequest assetRequest) {
        AssetResponse assetResponse = assetService.createAsset(assetRequest);
        if (assetResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(assetResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping("/bulk")
    public ResponseEntity<AssetBulkResponse> saveBulkAsset(@RequestBody List<AssetRequest> assetRequests) {
        AssetBulkResponse assetBulkResponse = assetService.saveBulkAsset(assetRequests);
        if (assetBulkResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(assetBulkResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping
    public ResponseEntity<AssetBulkResponse> getAllAssets() {
        AssetBulkResponse assetBulkResponse = assetService.findAllAssets();
        if (assetBulkResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(assetBulkResponse);
    }

    @GetMapping("/{assetName}")
    public ResponseEntity<AssetBulkResponse> getAssetByName(@PathVariable String assetName) {
        AssetBulkResponse assetBulkResponse = assetService.findAssetByName(assetName);
        if (assetBulkResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(assetBulkResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetResponse> updateAsset(@PathVariable String id, @RequestBody AssetRequest assetRequest) {
        AssetResponse assetResponse = assetService.updateAsset(id, assetRequest);
        if (assetResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(assetResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssetResponse> deleteAsset(@PathVariable String id) {
        AssetResponse assetResponse = assetService.deleteAsset(id);
        if (assetResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(assetResponse);
    }

}
