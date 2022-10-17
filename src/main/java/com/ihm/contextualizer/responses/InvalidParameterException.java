package com.ihm.contextualizer.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException() {
        super();
    }
    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidParameterException(String message) {
        super(message);
    }
    public InvalidParameterException(Throwable cause) {
        super(cause);
    }
}

