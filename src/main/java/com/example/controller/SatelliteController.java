package com.example.controller;

import com.example.dto.request.SatelliteRequestDto;
import com.example.dto.response.SatelliteResponseDto;
import com.example.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@Validated
public class SatelliteController {
    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto satelliteRequestDto) {

        SatelliteResponseDto satelliteResponseDto = satelliteService.updateIfDecommissioned(id, satelliteRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(satelliteResponseDto);
    }
}
