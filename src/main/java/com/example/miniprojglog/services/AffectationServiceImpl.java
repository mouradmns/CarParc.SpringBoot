package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.ClassificationPermis;
import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.exeptions.DriverNotAvailableException;
import com.example.miniprojglog.exeptions.DriverNotConformedException;
import com.example.miniprojglog.exeptions.VehicleNotAvailableException;
import com.example.miniprojglog.exeptions.VehiculeNotConformedException;
import com.example.miniprojglog.repository.VehicleRepo;
import com.example.miniprojglog.services.Interfaces.TripService;
import com.example.miniprojglog.services.Interfaces.VehiclesService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Builder
public class AffectationServiceImpl {

    @Autowired
    TripService tripSerice;

    @Autowired
    DisponibilityServiceImpl disponibilityService;
    ConformityServiceImpl conformityService;

    VehiclesService vehicleService;
    @Autowired
    private VehicleRepo vehicleRepo;

    public Trip affectation(LocalDate startDate, LocalDate endDate, Long driverId, Long vehicleId) throws DriverNotAvailableException, VehicleNotAvailableException, DriverNotConformedException, VehiculeNotConformedException {

          ClassificationPermis requiredPermis= vehicleRepo.getReferenceById(vehicleId).getPermisClassification();

         Driver disponibleDriver= conformityService.isDriverConforme(
                 disponibilityService.disponibleDriver(driverId,startDate,endDate),
                 endDate,
                 requiredPermis);


         Vehicle dispovehicle= conformityService.isVehicleConforme(
                 disponibilityService.disponibleVehicle(vehicleId,startDate,endDate),
                 endDate);





        if( disponibleDriver ==null){
            throw new DriverNotAvailableException("Driver not available for this date");
        }
        if( dispovehicle ==null){
            throw new VehicleNotAvailableException("Vehicle not available for this date");
        }

        Trip createdTrip =Trip.builder()
                .driver(disponibleDriver)
                        .vehicle(dispovehicle)
                                .build();


        createdTrip.setDateDebut(startDate);
        createdTrip.setDateFin(endDate);

        tripSerice.saveTrip(createdTrip);
        vehicleService.saveVehicule(dispovehicle);
        return createdTrip;
    }

}
 