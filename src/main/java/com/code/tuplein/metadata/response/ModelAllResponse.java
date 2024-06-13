package com.code.tuplein.metadata.response;

import java.util.List;

public record ModelAllResponse(List<ModelResponse> modelResponses, int count) {

}
