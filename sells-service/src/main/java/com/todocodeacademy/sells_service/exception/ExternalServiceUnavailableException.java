package com.todocodeacademy.sells_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ExternalServiceUnavailableException extends RuntimeException{
    public ExternalServiceUnavailableException(String message) {
        super(message);
    }
}
