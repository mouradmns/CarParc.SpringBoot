package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;

import java.util.Date;
import java.util.List;

public interface DisponibilityService {


    List<Conducteur> ConducteurDisponible(Date dateDebut, Date dateFin);
    List<Vehicule> VehiculeDisponible(Date dateDebut, Date dateFin);
}
