package com.example.miniprojglog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voyage {
    @Id
    private UUID  NumVoyage;

    private Date DateDebut;
    private Date DateFin;


    @ManyToOne(fetch = FetchType.LAZY)
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule;

}
