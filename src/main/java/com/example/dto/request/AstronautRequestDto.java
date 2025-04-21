package com.example.dto.request;

import jakarta.validation.constraints.*;

import java.util.List;

public record AstronautRequestDto(
        @NotBlank
        @Size(min = 2, max = 20)
        String firstName,

        @NotBlank
        @Size(min = 2, max = 20)
        String lastName,

        @Min(0)
        @Max(50)
        int experienceYears,

        List<@NotNull Long> satelliteIds
) {
}
