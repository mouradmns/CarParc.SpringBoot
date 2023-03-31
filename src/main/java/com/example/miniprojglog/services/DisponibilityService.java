package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;

import java.util.Date;
import java.util.List;

public interface DisponibilityService {

    Conducteur ConducteurDisponible(Long matriculeC,Date dateDebut, Date dateFin);

    List<Conducteur> ConducteursDisponible(Date dateDebut, Date dateFin);
}
