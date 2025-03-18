package com.ars.exceptions;

public class ApiException extends RuntimeException {
    private final ErrorInfo errorInfo;

    public ApiException(String message) {
        super(message);
        this.errorInfo = new ErrorInfo(400, message);
    }

    public ApiException(ErrorInfo errorInfo) {
        super(errorInfo.getErrorMessage());
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }
}
