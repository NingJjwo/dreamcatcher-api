package com.dreamcatcher.dreamcatcher_api.dto;

import java.time.Instant;

public record ErrorResponse(
        int status,
        String error,
        String message,
        long timestamp) {

    public static ErrorResponse of(int status, String error, String message) {
        return new ErrorResponse(status, error, message, Instant.now().toEpochMilli());
    }
}
