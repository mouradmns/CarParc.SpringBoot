package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;
import com.example.miniprojglog.repository.DisponibilityRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DisponibilityServiceImpl implements DisponibilityService {

        private DisponibilityRepo disponibilityRepo;


    @Override
    public List<Conducteur> ConducteurDisponible(Date dateDebut, Date dateFin) {
        return disponibilityRepo.conducteurDisponible(dateDebut, dateFin);
    }

    @Override
    public List<Vehicule> VehiculeDisponible(Date dateDebut, Date dateFin) {
        return null;
    }
}
