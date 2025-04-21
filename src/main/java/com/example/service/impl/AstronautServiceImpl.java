package com.example.service.impl;

import com.example.dto.request.AstronautRequestDto;
import com.example.dto.response.AstronautResponseDto;
import com.example.entity.Astronaut;
import com.example.entity.Satellite;
import com.example.repository.AstronautRepository;
import com.example.repository.SatelliteRepository;
import com.example.service.AstronautService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository, SatelliteRepository satelliteRepository) {
        this.astronautRepository = astronautRepository;
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto) {
        List<Satellite> satellites = satelliteRepository.findAllById(astronautRequestDto.satelliteIds());

        // Check if any satellite ID is invalid
        if (satellites.size() != astronautRequestDto.satelliteIds().size()) {
            throw new IllegalArgumentException("One or more satellite IDs are invalid.");
        }

        Astronaut astronaut = new Astronaut(
                astronautRequestDto.firstName(),
                astronautRequestDto.lastName(),
                astronautRequestDto.experienceYears(),
                satellites
        );

        astronautRepository.save(astronaut);

        return new AstronautResponseDto(
                astronaut.getId(),
                astronaut.getFirstName(),
                astronaut.getLastName(),
                astronaut.getExperienceYears(),
                astronaut.getSatellites().stream()
                        .map(Satellite::getId)
                        .toList()
        );
    }

    @Override
    public List<AstronautResponseDto> getAllAstronauts(String sortField, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ?
                Sort.by(sortField).descending() :
                Sort.by(sortField).ascending();

        List<Astronaut> astronauts = astronautRepository.findAll(sort);

        return astronauts.stream()
                .map(a -> new AstronautResponseDto(
                        a.getId(),
                        a.getFirstName(),
                        a.getLastName(),
                        a.getExperienceYears(),
                        a.getSatellites().stream().map(Satellite::getId).toList()
                ))
                .toList();
    }

}
