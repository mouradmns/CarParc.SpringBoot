package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepo extends JpaRepository<Vehicule, String> {
}
