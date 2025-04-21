package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record SatelliteRequestDto(
        @NotBlank
        String name,
        @Past
        LocalDate launchDate,
        Boolean decommissioned,
        @Pattern(
                regexp = "^(?i)(LEO|MEO|GEO)$",
                message = "Orbit type must be one of: LEO, MEO, GEO"
        )
        String orbitType
) {
}
