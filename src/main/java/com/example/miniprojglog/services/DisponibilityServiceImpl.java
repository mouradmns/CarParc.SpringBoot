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
    public Conducteur ConducteurDisponible(Long matriculeC,Date dateDebut, Date dateFin) {
        return disponibilityRepo.conducteurDisponible(matriculeC,dateDebut, dateFin);
    }

    @Override
    public List<Conducteur> ConducteursDisponible( Date dateDebut, Date dateFin) {
        return disponibilityRepo.conducteursDisponible(dateDebut,dateFin);
    }

}
