package com.vtd.controller;


import com.vtd.dto.request.AddTestRequest;
import com.vtd.dto.response.ApiResponse;
import com.vtd.service.TestService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TestController
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping(value = "/get-test/{id}")
    public ResponseEntity<ApiResponse> getTest(@PathVariable(value = "id") Integer id) {

        return ResponseEntity.ok(testService.getTest(id));
    }
    @PostMapping()
    public ResponseEntity<ApiResponse> saveTest(@Valid @RequestBody AddTestRequest addTestRequest) {
        return ResponseEntity.ok(testService.save(addTestRequest));
    }
    @DeleteMapping(value = "/delete-test/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(testService.delete(id));
    }
}
