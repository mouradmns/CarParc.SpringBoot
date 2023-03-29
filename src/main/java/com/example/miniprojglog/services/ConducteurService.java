package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;

import java.util.List;

public interface ConducteurService {
    Conducteur saveConducteur(Conducteur conducteur);
    Conducteur updateConducteur(Conducteur conducteur);
    Conducteur deleteConducteur(Long matriculeC);

    Conducteur getConducteurById(Long matriculeC);

    List<Conducteur>  listConducteurs();

 }
