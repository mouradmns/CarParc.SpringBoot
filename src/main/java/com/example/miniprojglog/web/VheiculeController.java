package com.example.miniprojglog.web;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;
import com.example.miniprojglog.services.ConducteurService;
import com.example.miniprojglog.services.VheiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class VheiculeController {

    @Autowired
    private VheiculeService vheiculeService;


    @PostMapping("/Vheicule")
    public ResponseEntity<Vehicule> saveVheicule(@RequestBody Vehicule vehicule) {

            Vehicule savedVehicle = vheiculeService.saveVheicule(vehicule);

        return ResponseEntity.ok(savedVehicle);
    }


    @GetMapping("/Vheicules/{vehiculeId}")
    public ResponseEntity<Vehicule> getVehicule(@PathVariable Long vehiculeId) {

        Vehicule  vehuculebyId=vheiculeService.getVheiculebyId(vehiculeId);

        return ResponseEntity.ok(vehuculebyId);
    }



    @PutMapping("/Vheicules/{vehiculeId}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long vehiculeId,@RequestBody Vehicule vehicule) {

        vehicule.setMatriculeV(vehiculeId);
        Vehicule updatedvehicle =vheiculeService.updateVheicule(vehicule);
        return ResponseEntity.ok(updatedvehicle);
    }



    @DeleteMapping("/Vheicules/{vehiculeId}")
    public ResponseEntity<Vehicule> deleteVehicule(@PathVariable Long vehiculeId) {
        Vehicule deletedVehicle=vheiculeService.deleteVheicule(vehiculeId);
        return ResponseEntity.ok(deletedVehicle);
    }

}
