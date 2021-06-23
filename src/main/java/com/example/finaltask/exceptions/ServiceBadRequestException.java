package com.example.finaltask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceBadRequestException extends ServiceException {
    public ServiceBadRequestException() {
    }

    public ServiceBadRequestException(String message) {
        super(message);
    }

    public ServiceBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
