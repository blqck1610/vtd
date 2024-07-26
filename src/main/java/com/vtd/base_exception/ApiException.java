package com.vtd.base_exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * ApiException
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiException extends RuntimeException  {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;

}
