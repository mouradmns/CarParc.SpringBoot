package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.repository.TripRepo;
import com.example.miniprojglog.services.Interfaces.TripService;
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
public class TripServiceImpl implements TripService {


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
    public void deleteTripById(Long tripId) {
        tripRepo.deleteById(tripId);
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
