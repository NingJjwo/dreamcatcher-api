package com.dreamcatcher.dreamcatcherapi.exception;


public class DreamcatcherException extends RuntimeException {
    private final int errorCode;
    private final String errorMessage;

    public DreamcatcherException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
