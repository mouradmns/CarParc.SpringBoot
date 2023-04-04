package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehiclesService {

        Vehicle saveVheicule(Vehicle vheicule);
        Vehicle updateVheicule(Vehicle vheicule);
        Vehicle deleteVheicule(Long matriculeC);

        Optional<Vehicle> getVheiculebyId(Long matriculeV);

        List<Vehicle> listvheicules();
        List<Vehicle> listOfAvailableVehicules();

}
