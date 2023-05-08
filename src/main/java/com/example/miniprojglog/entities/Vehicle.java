package com.example.miniprojglog.entities;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    ClassificationPermis permisClassification;


    @OneToMany(mappedBy = "vehicle")
    private List<Trip> trips;

    @OneToOne(cascade = CascadeType.ALL)
    private CarteGrise carteGrise;

    @OneToOne(cascade = CascadeType.ALL)
    private Assurance assurance;

    @OneToOne(cascade = CascadeType.ALL)
    private Vignette vignette;

    @OneToOne(cascade = CascadeType.ALL)
    private TechnicalVisit technicalVisit;


}
