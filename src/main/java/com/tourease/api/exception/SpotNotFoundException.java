package com.tourease.api.exception;

public class SpotNotFoundException extends RuntimeException {

    public SpotNotFoundException() {
        super();
    }

    public SpotNotFoundException(String message) {
        super(message);
    }
}