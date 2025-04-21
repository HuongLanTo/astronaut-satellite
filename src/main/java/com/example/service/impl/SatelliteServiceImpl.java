package com.example.service.impl;

import com.example.dto.request.SatelliteRequestDto;
import com.example.dto.response.SatelliteResponseDto;
import com.example.entity.Satellite;
import com.example.exception.InvalidSatelliteUpdateException;
import com.example.repository.SatelliteRepository;
import com.example.service.SatelliteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public SatelliteResponseDto updateIfDecommissioned(Long id, SatelliteRequestDto satelliteRequestDto) {
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
        if (optionalSatellite.isEmpty()) {
            throw new EntityNotFoundException("Satellite not found.");
        }

        Satellite satellite = optionalSatellite.get();

        if (!satellite.getDecommissioned()) {
            throw new InvalidSatelliteUpdateException("Satellite must be decommissioned before it can be updated.");
        }

        satellite.setName(satelliteRequestDto.name());
        satellite.setLaunchDate(satelliteRequestDto.launchDate());
        satellite.setOrbitType(satelliteRequestDto.orbitType());
        satellite.setDecommissioned(satelliteRequestDto.decommissioned());

        satellite = satelliteRepository.save(satellite);

        SatelliteResponseDto satelliteResponseDto = new SatelliteResponseDto(
                satellite.getId(),
                satellite.getName(),
                satellite.getLaunchDate(),
                satellite.getDecommissioned(),
                satellite.getOrbitType()
        );

        return satelliteResponseDto;
    }

}
