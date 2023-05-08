package com.example.miniprojglog.services;


import com.example.miniprojglog.entities.ClassificationPermis;
import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.TypePermis;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.exeptions.DriverNotConformedException;
import com.example.miniprojglog.repository.DriverRepo;
import com.example.miniprojglog.repository.VehicleRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class ConformityServiceImpl {


    VehicleRepo vehicleRepo;
    @Autowired
    DriverRepo driverRepo;

    public List<Vehicle> ConformeVehicle(LocalDate date_debut, LocalDate date_fin, ClassificationPermis typePermis) {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        return vehicles.stream()
                .filter( vehicle -> vehicle.getPermisClassification()== typePermis)
//                .filter( vehicle -> vehicle.getCarteGrise().getCarteEndDate().isBefore(LocalDate.now()))
//                .filter( vehicle -> vehicle.getAssurance().getAssuranceEndDate().isBefore(LocalDate.now()))
//                .filter( vehicle -> vehicle.getTechnicalVisit().getExpirationDate().isBefore(LocalDate.now()))
//                .filter( vehicle -> (vehicle.getTechnicalVisit().getExpirationDate().plusYears(1)).isBefore(LocalDate.now()))
                .collect(toList());
    }



    public List<Driver> ConformeDrivers(LocalDate date_debut, LocalDate date_fin,  ClassificationPermis typePermis)
           {
        List<Driver> drivers= driverRepo.findAll();
        log.info(drivers.toString());

        return drivers.stream()
                .filter(driver -> driver.getPermis().getLesPermis()
                        .stream().anyMatch(permi -> permi.getTypedePermis()== typePermis))
                .collect(toList());
    }


    public Driver isDriverConforme(Driver driver,LocalDate startDate, LocalDate endDate, ClassificationPermis typePermis) throws DriverNotConformedException {
        List<Driver> drivers = this.ConformeDrivers(startDate, endDate, typePermis);
        log.info(drivers.toString());
        Boolean found =drivers.stream().anyMatch(dr -> dr.equals(driver));
        if (found)
            return  driver;
        throw  new DriverNotConformedException("this driver is not conformed");
    }

    public Vehicle isVehicleConforme(Vehicle vehicle,LocalDate startDate, LocalDate endDate, ClassificationPermis typePermis) throws VehiculeNotConformedException {
        List<Vehicle> ves = this.ConformeVehicle(startDate, endDate, typePermis);
        log.info(ves.toString());
        Boolean found =ves.stream().anyMatch(dr -> dr.equals(vehicle));
        if (found)
            return vehicle;
        throw new VehiculeNotConformedException("this vehicle is not conformed");
    }

}
