package com.example.miniprojglog.web;


import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.services.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController

public class ConducteurRestController {


    @Autowired
    private ConducteurService conducteurService;


    @PostMapping("/conducteur")
    public ResponseEntity<Conducteur> saveConducteur(@RequestBody Conducteur conducteur) {

        Conducteur savedConducteur =conducteurService.saveConducteur(conducteur);

        return ResponseEntity.ok(savedConducteur);
    }


    @GetMapping("/conducteurs/{Conducteurid}")
    public ResponseEntity<Conducteur> getConducteur(@PathVariable Long conducteurId) {

        Conducteur condById=conducteurService.getConducteurById(conducteurId);

        return ResponseEntity.ok(condById);
    }



    @PutMapping("/conducteurs/{Conducteurid}")
    public ResponseEntity<Conducteur> updateConducteur(@PathVariable Long conducteurId,@RequestBody Conducteur conducteur) {

        conducteur.setMatriculeC(conducteurId);
        Conducteur updatedConducteur=conducteurService.updateConducteur(conducteur);

        return ResponseEntity.ok(updatedConducteur);
    }



    @DeleteMapping("/conducteurs/{Conducteurid}")
    public ResponseEntity<Conducteur> deleteConducteur(@PathVariable Long conducteurId) {

        Conducteur deletedCond=conducteurService.deleteConducteur(conducteurId);

        return ResponseEntity.ok(deletedCond);
    }
}
