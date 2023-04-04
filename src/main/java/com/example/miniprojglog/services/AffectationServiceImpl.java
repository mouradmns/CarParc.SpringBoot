package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class AffectationServiceImpl {

    @Autowired
    TripSericeImpl tripSerice;

    @Autowired
    DisponibilityServiceImpl disponibilityService;

    public Trip affectation(LocalDate startDate, LocalDate endDate, Driver driver, Vehicle vehicle){

        Trip createdTrip = new Trip();

        Driver disponibleDriver= disponibilityService.disponibleDriver(driver.getDriverId(),startDate,endDate);

        createdTrip.setDriver(disponibleDriver);
        createdTrip.setVehicle(vehicle);
        createdTrip.setDateDebut(startDate);
        createdTrip.setDateFin(endDate);

        tripSerice.saveTrip(createdTrip);
        vehicle.setAvailableVehicle(false);
        return createdTrip;
    }

}
