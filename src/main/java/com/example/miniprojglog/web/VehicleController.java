package com.example.miniprojglog.web;

import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.services.Interfaces.VehiclesService;
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
public class VehicleController {

    @Autowired
    private VehiclesService vehiclesService;


        @GetMapping("/vehicles")
    public List<Vehicle> reticules() {
        log.info("-=________controller");
            return vehiclesService.listVehicules();
    }
    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> saveReticule(@RequestBody Vehicle vehicle) {

            Vehicle savedVehicle = vehiclesService.saveVehicule(vehicle);

        return ResponseEntity.ok(savedVehicle);
    }



    @GetMapping("/vehicles/{id}")
    public Optional<Vehicle> getVehicle(@PathVariable Long id) {


        return vehiclesService.getVehiculebyId(id) ;
    }



    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {

        vehicle.setVehicleId(id);
        Vehicle updatedvehicle =vehiclesService.updateVehicule(vehicle);
        return ResponseEntity.ok(updatedvehicle);
    }



    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
        Vehicle deletedVehicle=vehiclesService.deleteVehicule(id);
        return ResponseEntity.ok(deletedVehicle);
    }

}
