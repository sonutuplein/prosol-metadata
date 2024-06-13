package com.code.tuplein.metadata.service;

import com.code.tuplein.metadata.common.data_types.DataTypeBulkResponse;
import com.code.tuplein.metadata.request.CoreRequest;
import com.code.tuplein.metadata.response.CoreAllResponse;

public interface CoreService {

    boolean isCoreDataPresent();

    void createCore(CoreRequest coreRequest);
    
    CoreAllResponse findAllCore();

    DataTypeBulkResponse findCoreDataTypes();

}
