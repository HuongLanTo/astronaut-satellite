package com.example.service;

import com.example.dto.request.SatelliteRequestDto;
import com.example.dto.response.SatelliteResponseDto;

public interface SatelliteService {
    SatelliteResponseDto updateIfDecommissioned(Long id, SatelliteRequestDto satelliteRequestDto);
}
