package com.example.dto.response;

import com.example.entity.Astronaut;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public record SatelliteResponseDto(
        Long id,
        String name,
        LocalDate launchDate,
        Boolean decommissioned,
        String orbitType
) {

}
