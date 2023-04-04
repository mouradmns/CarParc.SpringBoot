package com.example.miniprojglog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    private Long vehicleId;

    private String marque;

    private String modele;

    private Boolean availableVehicle;


    @OneToMany(mappedBy = "vehicle")
    private List<Trip> trips;

}
