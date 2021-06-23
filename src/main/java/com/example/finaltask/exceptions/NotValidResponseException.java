package com.example.finaltask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NotValidResponseException extends ServiceException {
    public NotValidResponseException() {
    }

    public NotValidResponseException(String message) {
        super(message);
    }

    public NotValidResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
