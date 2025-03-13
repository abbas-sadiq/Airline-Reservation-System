package com.ars.exceptions;

import org.springframework.http.HttpStatusCode;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }

}
