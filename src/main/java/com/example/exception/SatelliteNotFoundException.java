package com.example.exception;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(Long id) {
        super("Satellite with ID " + id + " not found");
    }
}