package com.example.exception;

public class InvalidSatelliteUpdateException extends RuntimeException {
    public InvalidSatelliteUpdateException(String message) {
        super(message);
    }
}
