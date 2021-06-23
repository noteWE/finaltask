package com.example.finaltask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQueryDataFormatException extends ServiceException {
    public InvalidQueryDataFormatException() {
    }

    public InvalidQueryDataFormatException(String message) {
        super(message);
    }

    public InvalidQueryDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
