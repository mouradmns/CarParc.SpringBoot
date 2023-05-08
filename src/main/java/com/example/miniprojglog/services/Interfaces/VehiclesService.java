package com.example.miniprojglog.services.Interfaces;

import com.example.miniprojglog.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehiclesService {

        Vehicle saveVehicule(Vehicle vheicule);
        Vehicle updateVehicule(Vehicle vheicule);
        Vehicle deleteVehicule(Long matriculeC);

        Optional<Vehicle> getVehiculebyId(Long matriculeV);

        List<Vehicle> listVehicules();
        List<Vehicle> listOfAvailableVehicules();

}
