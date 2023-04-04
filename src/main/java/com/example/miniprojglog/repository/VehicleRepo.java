package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    public List<Vehicle> listOfAvailableVehicules();
}
