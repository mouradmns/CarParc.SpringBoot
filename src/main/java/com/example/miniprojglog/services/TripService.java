package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.entities.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {

    Trip saveTrip(Trip trip);
    Trip updateTrip(Trip trip);
    Trip deleteTrip(Long tripId);
    Optional<Trip> getTripById(Long idTrip);
    List<Trip> listTrips();

}
