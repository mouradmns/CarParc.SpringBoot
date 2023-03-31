package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;

import java.util.List;

public interface VheiculeService {

    Vehicule saveVheicule( Vehicule vheicule);
    Vehicule updateVheicule(Vehicule vheicule);
    Vehicule deleteVheicule(Long matriculeC);

    Vehicule getVheiculebyId(Long matriculeV);

    List<Vehicule> listVheicules();

}
