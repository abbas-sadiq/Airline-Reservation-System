package com.ars.exceptions;

public class ApiException extends RuntimeException {
    private final ErrorInfo errorInfo;

    // ✅ Constructor for a custom error message (Default: 400 Bad Request)
    public ApiException(String message) {
        super(message);
        this.errorInfo = new ErrorInfo(400, message);
    }

    // ✅ Constructor for detailed ErrorInfo
    public ApiException(ErrorInfo errorInfo) {
        super(errorInfo.getErrorMessage());
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }
}
