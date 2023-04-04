package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.repository.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehiclesService {

    @Autowired
    private VehicleRepo vehicleRepo;
    @Override
    public Vehicle saveVheicule(Vehicle vheicule) {
        return vehicleRepo.save(vheicule);
    }

    @Override
    public Vehicle updateVheicule(Vehicle vheicule) {
        return vehicleRepo.save(vheicule);
    }

    @Override
    public Vehicle deleteVheicule(Long matriculeV) {
        Vehicle deletedVehicle = vehicleRepo.getReferenceById(matriculeV);
        vehicleRepo.delete(deletedVehicle);
        return deletedVehicle;
    }

    @Override
    public Optional<Vehicle> getVheiculebyId(Long id) {
        return vehicleRepo.findById(id);
    }

    @Override
    public List<Vehicle> listvheicules() {

        return vehicleRepo.findAll();
    }

    @Override
    public List<Vehicle> listOfAvailableVehicules() {
        return null;
    }
}
