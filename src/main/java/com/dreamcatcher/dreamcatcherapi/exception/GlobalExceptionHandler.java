package com.dreamcatcher.dreamcatcherapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DreamcatcherException.class)
    public ResponseEntity<Map<String, Object>> handleDreamcatcherException(DreamcatcherException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("errorCode", ex.getErrorCode());
        errorResponse.put("errorMessage", ex.getErrorMessage());
        errorResponse.put("status", HttpStatus.valueOf(ex.getErrorCode()).getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode()));
    }
}
