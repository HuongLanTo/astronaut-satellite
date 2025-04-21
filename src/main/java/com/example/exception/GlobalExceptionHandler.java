package com.example.exception;

import com.example.dto.ApiErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiErrorDto> handleSatelliteNotFound(
            SatelliteNotFoundException ex, HttpServletRequest request) {
        ApiErrorDto error = new ApiErrorDto(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AstronautNotFoundException.class)
    public ResponseEntity<ApiErrorDto> handleAstronautNotFound(
            AstronautNotFoundException ex, HttpServletRequest request) {
        ApiErrorDto error = new ApiErrorDto(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidSatelliteUpdateException.class)
    public ResponseEntity<ApiErrorDto> handleInvalidUpdate(
            InvalidSatelliteUpdateException ex, HttpServletRequest request) {
        ApiErrorDto error = new ApiErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
