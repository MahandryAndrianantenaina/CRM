package itu.com.CRM.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private final int errorCode;
    private final String errorMessage;
    private final String errorType;
    private final String stackFullTrace;

    public ApiException(int errorCode, String errorMessage, String errorType, String stackFullTrace) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.stackFullTrace = stackFullTrace;
    }
}
