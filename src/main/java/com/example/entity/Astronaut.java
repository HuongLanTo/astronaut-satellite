package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "astronauts")
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String lastName;

    @Min(0)
    @Max(50)
    private int experienceYears;

    @ManyToMany
    @JoinTable(
            name = "astronaut_satellite",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private List<Satellite> satellites = new ArrayList<>();

    public Astronaut() {
    }

    public Astronaut(String firstName, String lastName, int experienceYears, List<Satellite> satellites) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
        this.satellites = satellites;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }
}
