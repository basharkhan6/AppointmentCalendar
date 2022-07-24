package com.example.appointmentcalendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found!!");
    }

    public ResourceNotFoundException(Long id) {
        super(String.format("Resource not found with id %d", id));
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        super(String.format("%s not found with id %d", resourceName, id));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
