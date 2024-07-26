package com.vtd.base_exception.handlerException;

import com.vtd.base_exception.ApiException;
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

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handlerApiException(ApiException e) {
        System.out.println("exception: " + e.getMessage());
        return ResponseEntity.status(e.getCode()).body(e.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handlerBindException(BindException e) {
        String errorMessage = "invalid request!";
        if (e.getBindingResult().hasErrors()) {
            errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return ResponseEntity.status(400).body(errorMessage);

    }
}
