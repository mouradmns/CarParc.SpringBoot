package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DisponibilityService {

    Driver disponibleDriver(Long driverId, LocalDate dateDebut, LocalDate dateFin);

    List<Driver> disponibleDrivers(LocalDate dateDebut,LocalDate dateFin);


}
