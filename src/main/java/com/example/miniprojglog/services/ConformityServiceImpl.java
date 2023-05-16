package com.example.miniprojglog.services;


import com.example.miniprojglog.entities.ClassificationPermis;
import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.exeptions.DriverNotConformedException;
import com.example.miniprojglog.exeptions.VehiculeNotConformedException;
import com.example.miniprojglog.repository.DriverRepo;
import com.example.miniprojglog.repository.VehicleRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class ConformityServiceImpl {


    VehicleRepo vehicleRepo;
    DriverRepo driverRepo;




    public List<Driver> ConformeDrivers( LocalDate date_fin,  ClassificationPermis typePermis)
           {
        List<Driver> drivers= driverRepo.findAll();
        log.info(drivers.toString());

        return drivers.stream()
                .filter(driver -> driver.getPermis().getLesPermis()
                        .stream().anyMatch(permi -> permi.getTypedePermis()== typePermis)
                &&
                        driver.getPermis().getLesPermis()
                        .stream().anyMatch(permi->permi.getExpirationDate().isAfter(date_fin)))
                .collect(toList());
    }



    public Driver isDriverConforme(Driver driver, LocalDate endDate, ClassificationPermis typePermis) throws DriverNotConformedException {
        List<Driver> drivers = this.ConformeDrivers( endDate, typePermis);

        log.info("++++++++List of conforme Drivers: " + drivers.toString());
        log.info(drivers.toString());

        Boolean found =drivers.stream().anyMatch(dr -> dr.equals(driver));
        if (found)
            return  driver;
        throw  new DriverNotConformedException("this driver is not conformed");
    }








    public List<Vehicle> ConformeVehicles(LocalDate endDate) {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        log.info("++++++++List of all vecs: " + vehicles.toString());
        return vehicles.stream()
                .filter(vehicle -> vehicle.getCarteGrise().getCarteEndDate().isAfter(endDate)
                        && vehicle.getAssurance().getAssuranceEndDate().isAfter(endDate)
                        && vehicle.getTechnicalVisit().getEndDate().isAfter(endDate)
                )
                .collect(toList());
    }



    public Vehicle isVehicleConforme(Vehicle vehicle,LocalDate endDate) throws VehiculeNotConformedException {
        List<Vehicle> vecs = this.ConformeVehicles(endDate);
        log.info("++++++++List of conforme vecs: " + vecs.toString());
        Boolean found =vecs.stream().anyMatch(dr -> dr.equals(vehicle));
        if (found)
            return vehicle;
        throw new VehiculeNotConformedException("this vehicle is not conformed");
    }

}
