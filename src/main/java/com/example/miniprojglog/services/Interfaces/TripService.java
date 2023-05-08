package com.example.miniprojglog.services.Interfaces;

import com.example.miniprojglog.entities.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {

    Trip saveTrip(Trip trip);
    Trip updateTrip(Trip trip);
    void deleteTripById(Long tripId);
    Optional<Trip> getTripById(Long idTrip);
    List<Trip> listTrips();

}
