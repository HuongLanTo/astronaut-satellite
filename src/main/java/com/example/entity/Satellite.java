package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "satellites")
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Past
    private LocalDate launchDate;

    @Pattern(regexp = "^(?i)(LEO|MEO|GEO|HEO)$")
    private String orbitType;

    private boolean decommissioned;

    @ManyToMany(mappedBy = "satellites")
    private List<Astronaut> astronauts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public boolean getDecommissioned() {
        return decommissioned;
    }

    public List<Astronaut> getAstronauts() {
        return astronauts;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public void setDecommissioned(boolean decommissioned) {
        this.decommissioned = decommissioned;
    }

    public void setAstronauts(List<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }
}
