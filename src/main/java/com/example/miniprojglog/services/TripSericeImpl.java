package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.repository.TripRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class TripSericeImpl implements TripService{


     @Autowired
     private  TripRepo tripRepo;
    @Override
    public Trip saveTrip(Trip trip) {

        return tripRepo.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        return tripRepo.save(trip);
    }

    @Override
    public Trip deleteTrip(Long tripId) {

         Optional<Trip> toDeleteTrip  = tripRepo.findById(tripId);

        return tripRepo.delete(toDeleteTrip);
    }

    @Override
    public Optional<Trip> getTripById(Long tripId) {
        return tripRepo.findById(tripId);
    }

    @Override
    public List<Trip> listTrips() {
        return tripRepo.findAll();
    }
}
