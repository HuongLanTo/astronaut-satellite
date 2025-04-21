package com.example.service;

import com.example.dto.request.AstronautRequestDto;
import com.example.dto.response.AstronautResponseDto;

import java.util.List;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto);
    List<AstronautResponseDto> getAllAstronauts(String sortField, String order);

}
