package com.vtd.mapper;

import com.vtd.dto.request.AddTestRequest;
import com.vtd.entity.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * TestMapper
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
@Component
public class TestMapper {
    /**
     * convert AddTestRequest to Test
     * @param addTestRequest
     * @return
     */
    public Test fromAddTestRequest(AddTestRequest addTestRequest) {
        return Test.builder()
                .name(addTestRequest.name())
                .build();
    }
}
