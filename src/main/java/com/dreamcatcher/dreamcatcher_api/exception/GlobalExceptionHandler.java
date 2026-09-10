package com.dreamcatcher.dreamcatcher_api.exception;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String TYPE_BASE = "https://api.dreamcatcher.dev/errors/";
    private static final URI TYPE_RESOURCE_NOT_FOUND = URI.create(TYPE_BASE + "resource-not-found");
    private static final URI TYPE_VALIDATION = URI.create(TYPE_BASE + "validation");
    private static final URI TYPE_MALFORMED_BODY = URI.create(TYPE_BASE + "malformed-body");
    private static final URI TYPE_METHOD_NOT_ALLOWED = URI.create(TYPE_BASE + "method-not-allowed");
    private static final URI TYPE_ENDPOINT_NOT_FOUND = URI.create(TYPE_BASE + "endpoint-not-found");
    private static final URI TYPE_DATA_ACCESS = URI.create(TYPE_BASE + "data-access");
    private static final URI TYPE_INTERNAL = URI.create(TYPE_BASE + "internal");

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex) {
        return buildProblem(HttpStatus.NOT_FOUND, TYPE_RESOURCE_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new FieldError(fe.getField(), fe.getDefaultMessage()))
                .toList();
        ProblemDetail problem = buildProblem(HttpStatus.BAD_REQUEST, TYPE_VALIDATION, "Request validation failed");
        problem.setProperty("errors", errors);
        return problem;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ProblemDetail handleMissingParam(MissingServletRequestParameterException ex) {
        String message = String.format("Required parameter '%s' is missing", ex.getParameterName());
        return buildProblem(HttpStatus.BAD_REQUEST, TYPE_VALIDATION, message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ProblemDetail handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = String.format("Parameter '%s' must be of type %s",
                ex.getName(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown");
        return buildProblem(HttpStatus.BAD_REQUEST, TYPE_VALIDATION, message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleUnreadable(HttpMessageNotReadableException ex) {
        return buildProblem(HttpStatus.BAD_REQUEST, TYPE_MALFORMED_BODY, "Malformed request body");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String message = String.format("Method '%s' is not supported for this endpoint", ex.getMethod());
        return buildProblem(HttpStatus.METHOD_NOT_ALLOWED, TYPE_METHOD_NOT_ALLOWED, message);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ProblemDetail handleNoResource(NoResourceFoundException ex) {
        return buildProblem(HttpStatus.NOT_FOUND, TYPE_ENDPOINT_NOT_FOUND, "Endpoint not found");
    }

    @ExceptionHandler(DataAccessException.class)
    public ProblemDetail handleDataAccess(DataAccessException ex) {
        log.error("failed_data_access", ex);
        return buildProblem(HttpStatus.SERVICE_UNAVAILABLE, TYPE_DATA_ACCESS, "Service temporarily unavailable");
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(Exception ex) {
        log.error("unexpected_error", ex);
        return buildProblem(HttpStatus.INTERNAL_SERVER_ERROR, TYPE_INTERNAL, "An unexpected error occurred");
    }

    private ProblemDetail buildProblem(HttpStatus status, URI type, String detail) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setType(type);
        return problem;
    }

    private record FieldError(String field, String message) {
    }
}