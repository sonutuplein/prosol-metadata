package com.code.tuplein.metadata.controller;

import com.code.tuplein.metadata.common.data_types.DataTypeBulkResponse;
import com.code.tuplein.metadata.response.CoreAllResponse;
import com.code.tuplein.metadata.service.CoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/core")
public class CoreController {
    private final CoreService coreService;

    @GetMapping
    public ResponseEntity<CoreAllResponse> getAllCore() {
        CoreAllResponse coreResponses = coreService.findAllCore();
        if (coreResponses == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(coreResponses);
    }

    @GetMapping("/dataTypes")
    public ResponseEntity<DataTypeBulkResponse> getDataTypes() {
        DataTypeBulkResponse response = coreService.findCoreDataTypes();
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }
}
