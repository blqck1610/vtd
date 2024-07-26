package com.vtd.service;

import com.vtd.base_exception.ApiException;
import com.vtd.dto.request.AddTestRequest;
import com.vtd.dto.response.ApiResponse;
import com.vtd.entity.Test;
import com.vtd.mapper.TestMapper;
import com.vtd.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TestService
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    private final TestRepository testRepository;
    private final TestMapper mapper;

    /**
     * get test from database
     * @param id
     * @return
     */
    public ApiResponse getTest(int id) {
        Test test = testRepository.findById(id).orElse(null);
        if(test == null){
            return new ApiResponse(404, "could not find test for id: " + id , null);
        }
        return new ApiResponse(200 , "OK", test);
    }

    /**
     * delete test
     * @param id
     * @return
     */
    public ApiResponse delete(int id) {
        try {
            Test test = testRepository.getReferenceById(id);
            testRepository.delete(test);
            return new ApiResponse(200, "delete successfully", null);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ApiResponse(400 , " delete failed", null);
        }
    }

    /**
     *  save test to database
     * @param addTestRequest
     * @return
     */
    public ApiResponse save(AddTestRequest addTestRequest) {
        try {
            Test test = testRepository.save(mapper.fromAddTestRequest(addTestRequest));
            return new ApiResponse(200 , "OK", test);

        }catch (Exception e) {
            log.error(e.getMessage());
            return new ApiResponse(400, "Could not save test: " + addTestRequest.toString(), null);

        }
    }

}
