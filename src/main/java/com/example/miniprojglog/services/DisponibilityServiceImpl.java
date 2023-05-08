package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.repository.DisponibilityRepo;
import com.example.miniprojglog.repository.DriverRepo;
import com.example.miniprojglog.repository.VehicleRepo;
import com.example.miniprojglog.services.Interfaces.DisponibilityService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DisponibilityServiceImpl implements DisponibilityService {
    private final VehicleRepo vehicleRepo;
    private final DriverRepo driverRepo;

    private DisponibilityRepo disponibilityRepo;


    @Override
    public Driver disponibleDriver(Long driverId, LocalDate dateDebut, LocalDate dateFin) {
//        return disponibilityRepo.disponibleDriver(driverId,dateDebut,dateFin);
    return driverRepo.getReferenceById(driverId);
    }

    @Override
    public List<Driver> disponibleDrivers(LocalDate dateDebut, LocalDate dateFin) {
        return disponibilityRepo.disponibleDrivers(dateDebut,dateFin);
    }

    @Override
    public Vehicle disponibleVehicle(Long vehiculeId, LocalDate dateDebut, LocalDate dateFin) {
//        return disponibilityRepo.disponibleVehicle(driverId,dateDebut,dateFin);
    return vehicleRepo.getReferenceById(vehiculeId);
    }

    @Override
    public List<Vehicle> disponibleVehicles(LocalDate dateDebut, LocalDate dateFin) {
        return disponibilityRepo.disponibleVehicles(dateDebut,dateFin);
    }
}
