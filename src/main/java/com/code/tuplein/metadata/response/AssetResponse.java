package com.code.tuplein.metadata.response;

import java.util.Map;

public record AssetResponse(String id,
                            String assetName,
                            Map<String, String> attributes
) {
}
