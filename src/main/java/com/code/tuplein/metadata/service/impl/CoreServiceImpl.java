package com.code.tuplein.metadata.service.impl;

import com.code.tuplein.metadata.common.data_types.DataTypeBulkResponse;
import com.code.tuplein.metadata.common.data_types.DataTypeDto;
import com.code.tuplein.metadata.common.data_types.DataTypeMapper;
import com.code.tuplein.metadata.entity.Core;
import com.code.tuplein.metadata.mapper.CoreMapper;
import com.code.tuplein.metadata.repository.CoreRepository;
import com.code.tuplein.metadata.request.CoreRequest;
import com.code.tuplein.metadata.response.CoreAllResponse;
import com.code.tuplein.metadata.response.CoreResponse;
import com.code.tuplein.metadata.service.CommonQueryService;
import com.code.tuplein.metadata.service.CoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoreServiceImpl implements CoreService {

    private final CoreRepository coreRepository;
    private final CommonQueryService commonQueryService;
    private final CoreMapper coreMapper;
    private final DataTypeMapper dataTypeMapper;

    @Override
    public void createCore(CoreRequest coreRequest) {
        Core core = coreMapper.toEntity(coreRequest);
        coreRepository.save(core);
    }

    @Override
    public boolean isCoreDataPresent() {
        return coreRepository.count() > 0;
    }

    @Override
    public CoreAllResponse findAllCore() {
        List<CoreResponse> responses = coreRepository.findAll().stream().map(coreMapper::toResponse).toList();
        int count = responses.size();
        return new CoreAllResponse(responses, count);
    }

    @Override
    public DataTypeBulkResponse findCoreDataTypes() {
        List<DataTypeDto> dataTypeResponses = commonQueryService.findCoreDataTypes()
                .stream().map(dataTypeMapper::toResponse).toList();
        int totalCount = dataTypeResponses.size();
        return new DataTypeBulkResponse(dataTypeResponses, totalCount);
    }
}
