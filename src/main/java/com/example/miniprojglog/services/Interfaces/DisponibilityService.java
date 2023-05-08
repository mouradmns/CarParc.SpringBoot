package com.example.miniprojglog.services.Interfaces;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Vehicle;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DisponibilityService {

    Driver disponibleDriver(Long driverId, LocalDate dateDebut, LocalDate dateFin);

    List<Driver> disponibleDrivers(LocalDate dateDebut,LocalDate dateFin);


    Vehicle disponibleVehicle(Long driverId, LocalDate dateDebut, LocalDate dateFin);

    List<Vehicle> disponibleVehicles(LocalDate dateDebut,LocalDate dateFin);


}
