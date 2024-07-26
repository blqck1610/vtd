package com.vtd.dto.response;

/**
 * ApiResponse
 * Version 1.0
 * Date: 26/07/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 26/07/2024        NGUYEN             create
 */
public record ApiResponse(Integer code, String message, Object data) {
}
