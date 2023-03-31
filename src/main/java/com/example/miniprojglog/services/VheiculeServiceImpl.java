package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Vehicule;
import com.example.miniprojglog.repository.VehiculeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VheiculeServiceImpl implements VheiculeService {

    @Autowired
    private VehiculeRepo vehiculeRepo;
    @Override
    public Vehicule saveVheicule(Vehicule vheicule) {
        return vehiculeRepo.save(vheicule);
    }

    @Override
    public Vehicule updateVheicule(Vehicule vheicule) {
        return vehiculeRepo.save(vheicule);
    }

    @Override
    public Vehicule deleteVheicule(Long matriculeV) {
        Vehicule deletedVehicule = vehiculeRepo.getReferenceById(matriculeV);
        vehiculeRepo.delete(deletedVehicule);
        return deletedVehicule;
    }

    @Override
    public Vehicule getVheiculebyId(Long matriculeV) {
        return vehiculeRepo.getReferenceById(matriculeV);
    }

    @Override
    public List<Vehicule> listVheicules() {
        return vehiculeRepo.findAll();
    }
}
