package com.vtd.base_exception.handlerException;

import com.vtd.base_exception.ApiException;
import com.vtd.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ApiExceptionHandler
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  handle api expention
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handlerApiException(ApiException e) {

        return ResponseEntity.ok(new ApiResponse(e.getCode(), e.getMessage(), null));
    }


    /**
     * handle bind exception
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handlerBindException(BindException e) {
        String errorMessage = "invalid request!";
        if (e.getBindingResult().hasErrors()) {
            errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return ResponseEntity.ok().body(new ApiResponse(400, errorMessage, null));

    }
}
