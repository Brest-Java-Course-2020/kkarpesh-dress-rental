package com.epam.brest.courses.rest_app.exception;

public class DressNotFoundException extends RuntimeException {

    public DressNotFoundException(Integer id) {
        super("Dress id not found: " + id);
    }
}
