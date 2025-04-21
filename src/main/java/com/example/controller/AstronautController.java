package com.example.controller;

import com.example.dto.request.AstronautRequestDto;
import com.example.dto.response.AstronautResponseDto;
import com.example.service.AstronautService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@Validated
public class AstronautController {
    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(@Valid @RequestBody AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto astronautResponseDto = astronautService.createAstronaut(astronautRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAllAstronauts(
            @RequestParam String sort,
            @RequestParam String order) {
        List<AstronautResponseDto> astronautResponseDtoList = astronautService.getAllAstronauts(sort, order);
        return ResponseEntity.status(HttpStatus.OK).body(astronautResponseDtoList);
    }
}
