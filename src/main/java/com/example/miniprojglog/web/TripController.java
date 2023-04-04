package com.example.miniprojglog.web;


import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.services.TripService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class TripController {

    @Autowired
    private TripService tripService;


    @GetMapping("/trips")
    public List<Trip> trips() {
        return  tripService.listTrips();
    }


    @GetMapping("/trips/{id}")
    public Optional<Trip> gettrip(@PathVariable Long id) {
        Optional<Trip> tripById= tripService.getTripById(id);
        return tripById;
    }

    @PostMapping("/trips")
    public ResponseEntity<Trip> saveTrip(@RequestBody Trip trip) {

        Trip savedTrip = tripService.saveTrip(trip);

        return ResponseEntity.ok(savedTrip);
    }



    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
       trip.setTripId(id);
       Trip tripUpd= tripService.updateTrip(trip);
        return ResponseEntity.ok(tripUpd);
    }



    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable Long id) {
        Trip deletedTrip= tripService.deleteTrip(id);
        return ResponseEntity.ok(deletedTrip);
    }





}
