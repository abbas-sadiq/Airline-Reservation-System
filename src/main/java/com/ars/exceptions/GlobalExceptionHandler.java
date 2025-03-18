package com.ars.exceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiResponse<ErrorInfo>> buildErrorResponse(HttpStatus status, int errorCode, String message) {
        ApiResponse<ErrorInfo> response = new ApiResponse<>(false, null, new ErrorInfo(errorCode, message));
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<ErrorInfo>> handleApiException(ApiException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getErrorInfo().getErrorCode(), ex.getErrorInfo().getErrorMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<ErrorInfo>> handleNoSuchElementException(NoSuchElementException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, 404, "Resource not found: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<ErrorInfo>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, 400, "Invalid request: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ErrorInfo>> handleGlobalException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Unexpected error: " + ex.getMessage());
    }
}
