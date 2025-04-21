package com.example.dto.response;

import jakarta.validation.constraints.*;

import java.util.List;

public record AstronautResponseDto(
        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        List<Long> satelliteIds
) {
}
