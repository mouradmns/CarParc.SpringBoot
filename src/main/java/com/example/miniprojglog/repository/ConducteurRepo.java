package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConducteurRepo extends JpaRepository<Conducteur, Long> {
}
