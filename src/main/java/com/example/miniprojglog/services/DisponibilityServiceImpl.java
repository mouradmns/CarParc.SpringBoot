package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.repository.DisponibilityRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DisponibilityServiceImpl implements DisponibilityService {

        private DisponibilityRepo disponibilityRepo;


    @Override
    public Driver disponibleDriver(Long driverId, LocalDate dateDebut, LocalDate dateFin) {
        return disponibilityRepo.disponibleDriver(driverId,dateDebut,dateFin);
    }

    @Override
    public List<Driver> disponibleDrivers(LocalDate dateDebut, LocalDate dateFin) {
        return disponibilityRepo.disponibleDrivers(dateDebut,dateFin);
    }
}
