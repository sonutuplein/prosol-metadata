package com.code.tuplein.metadata.request;

import java.util.Map;

public record AssetRequest(
        String assetName,
        Map<String, String> attributes
) {
}
