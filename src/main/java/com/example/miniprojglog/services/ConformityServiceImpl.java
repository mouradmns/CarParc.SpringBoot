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

    public List<Vehicle> ConformeVehicle( ) {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        log.info("++++++++List of all vecs: " + vehicles.toString());
        LocalDate currentDate = LocalDate.now();
        return vehicles.stream()
                .filter(vehicle -> vehicle.getCarteGrise().getCarteEndDate().isAfter(currentDate)
                        && vehicle.getAssurance().getAssuranceEndDate().isAfter(currentDate)
                        && vehicle.getTechnicalVisit().getStartDate().plusYears(1).isAfter(currentDate)
                )
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
        log.info("++++++++List of conforme Drivers: " + drivers.toString());
        log.info(drivers.toString());
        Boolean found =drivers.stream().anyMatch(dr -> dr.equals(driver));
        if (found)
            return  driver;
        throw  new DriverNotConformedException("this driver is not conformed");
    }

    public Vehicle isVehicleConforme(Vehicle vehicle) throws VehiculeNotConformedException {
        List<Vehicle> vecs = this.ConformeVehicle();
        log.info("++++++++List of conforme vecs: " + vecs.toString());
        Boolean found =vecs.stream().anyMatch(dr -> dr.equals(vehicle));
        if (found)
            return vehicle;
        throw new VehiculeNotConformedException("this vehicle is not conformed");
    }

}
