package com.code.tuplein.metadata.response;

import java.util.List;

public record AssetBulkResponse(List<AssetResponse> assetResponses, int count) {

}
