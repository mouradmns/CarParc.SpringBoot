package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepo extends JpaRepository<Trip, Long> {
    Trip delete(Optional<Trip> toDeleteTrip);
}
